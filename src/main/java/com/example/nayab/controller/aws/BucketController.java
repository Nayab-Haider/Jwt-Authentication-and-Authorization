package com.example.nayab.controller.aws;

import com.example.nayab.service.aws.AmazonClient;
import com.example.nayab.service.aws.AmazonClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/aws/bucket")
public class BucketController {

    @Autowired
    AmazonClient amazonClient;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestHeader("Authorization") String authKey, @RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<?> deleteFile(@RequestHeader("Authorization") String authKey, @RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/getFile/{fileName}")
    public ResponseEntity<?> getFile(@RequestHeader("Authorization") String authKey, @PathVariable String fileName) {
        return this.amazonClient.getFile(fileName);
    }
}
