package com.intelliguru.javalearning.fileops.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Getter
public class FileConfig {
    private Path fileStorageLocation;

    @Value("${file.upload-dir}")
    private String uploadDir;
    @PostConstruct
    public void init() throws IOException {
        fileStorageLocation = Paths.get(uploadDir)
                .toAbsolutePath()
                .normalize();

        Files.createDirectories(fileStorageLocation);
    }
}
