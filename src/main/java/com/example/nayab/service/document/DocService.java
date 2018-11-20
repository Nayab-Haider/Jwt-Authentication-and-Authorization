package com.example.nayab.service.document;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface DocService {

    ResponseEntity<?> uploadDocument(MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
