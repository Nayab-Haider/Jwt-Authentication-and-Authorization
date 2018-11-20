package com.example.nayab.controller.document;

import com.example.nayab.service.document.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class DocumentController {

    @Autowired
    private DocService docService;

    @PostMapping("/upload")
    ResponseEntity<?> uploadDoc(@RequestHeader("Authorization") String authKey,@RequestParam("file") MultipartFile file){
        return docService.uploadDocument(file);
    }

    @GetMapping("/download/{fileName:.+}")
    ResponseEntity<?> downloadDoc(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = docService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            return new ResponseEntity("Could not determine file type.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
