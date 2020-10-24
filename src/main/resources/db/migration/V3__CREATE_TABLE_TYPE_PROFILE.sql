CREATE TABLE type_profile(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    profile_id INT NOT NULL,
    profile_types INT NOT NULL,
    CONSTRAINT profile_fk
       FOREIGN KEY (profile_id)
       REFERENCES profile(id)
);