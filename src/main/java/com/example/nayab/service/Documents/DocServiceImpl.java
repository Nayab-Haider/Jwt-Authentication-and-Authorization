package com.example.nayab.service.Documents;

import com.example.nayab.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class DocServiceImpl implements DocService {

    private final Path fileStorageLocation;

    @Autowired
    public DocServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new CustomException("Could not create the directory where the uploaded files will be stored.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> uploadDocument(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new CustomException("Sorry! Filename contains invalid path sequence " + fileName,HttpStatus.INTERNAL_SERVER_ERROR);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to upload Document",HttpStatus.OK);
        }
        return new ResponseEntity<>("Document upload Successfully",HttpStatus.OK);
    }

    @Override
    public Resource loadFileAsResource(String fileName) {

        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new CustomException("File not found " + fileName,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (MalformedURLException ex) {
            throw new CustomException("File not found " + fileName,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
