package com.stor.car.uploads;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class FireBaseStorageService {

    private final static String URL_FIREBASE = "https://storage.googleapis.com/";
    private final static String NAME_BUCKET = "odonto-ds3t-374b0.appspot.com";
    private final static  String RESOURCE_FIREBASE_KEY = "/firebase/odonto-ds3t-374b0-firebase-adminsdk-5iv5c-1a4e626af4.json";

    @PostConstruct
    public void init() throws IOException {
        //read file config
        if(FirebaseApp.getApps().isEmpty()){
            InputStream serviceAccount = FireBaseStorageService.class
                    .getResourceAsStream(RESOURCE_FIREBASE_KEY);
            
            //definer data required to access storage
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket(NAME_BUCKET)
                    .build();
            
            //initializer client service Firebase
            FirebaseApp.initializeApp(options);
        }
    }

    public String uploadFileBase4(FileUpload file, String name){
        Bucket bucket = StorageClient.getInstance().bucket();

        byte[] fileEmBytes = Base64.getDecoder().decode(file.getBase64());
        Blob blob = bucket.create( name, fileEmBytes, file.getMimeType() );

        blob.createAcl(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        return  URL_FIREBASE + bucket.getName() + "/" + name ;
    }

}
