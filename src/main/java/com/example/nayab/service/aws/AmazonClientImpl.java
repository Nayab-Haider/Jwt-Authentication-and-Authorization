package com.example.nayab.service.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.example.nayab.util.response.ResponseDomain;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
public class AmazonClientImpl implements AmazonClient {

    private AmazonS3 s3client;

    @Value("${s3.url}")
    private String endpointUrl;

    @Value("${s3.bucket_name}")
    private String bucketName;

    @Value("${aws.access_key_id}")
    private String accessKeyId;

    @Value("${aws.secret_access_key}")
    private String secretKey;

    @Value("${s3.region}")
    private String region;

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKeyId, this.secretKey);

            this.s3client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(this.region))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

    }


    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(new Date().getTime() + "-" + file.getOriginalFilename().replace(" ", "_"));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file)  {
        File convFile=null;
        try {
            convFile=convertMultiPartToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, secretKey, convFile);
        putObjectRequest.setMetadata(new ObjectMetadata());
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObjectRequest);
        return new ResponseEntity<>("File Uploaded Successfully", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> deleteFileFromS3Bucket(String fileUrl) {

        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFile(String fileName) {
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, fileName);
            S3Object s3Object = s3client.getObject(getObjectRequest);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", endpointUrl + s3Object.getKey());
            return new ResponseEntity<>(jsonObject, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>("File Name does not exist", HttpStatus.BAD_REQUEST);
        }
    }
}
