package com.example.nayab.service.document;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "file")
public class FileStorageServiceProperties {

    private String uploadDir;
}
