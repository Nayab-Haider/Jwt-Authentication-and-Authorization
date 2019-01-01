package com.example.nayab.service.aws;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface AmazonClient {

    ResponseEntity<?> uploadFile(MultipartFile file);

    ResponseEntity<?> deleteFileFromS3Bucket(String fileUrl);

    ResponseEntity<?> getFile(String fileName);
}
