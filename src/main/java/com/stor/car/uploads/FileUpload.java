package com.stor.car.uploads;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileUpload {
    private String mimeType;
    private String base64;
}
