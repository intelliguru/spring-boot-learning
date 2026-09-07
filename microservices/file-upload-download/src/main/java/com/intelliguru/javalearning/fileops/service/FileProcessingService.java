package com.intelliguru.javalearning.fileops.service;

import com.intelliguru.javalearning.fileops.config.FileConfig;
import com.intelliguru.javalearning.fileops.exception.FileNotFoundException;
import com.intelliguru.javalearning.fileops.exception.FileStoreException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileProcessingService {

    private final FileConfig fileConfig;


    public String uploadFile(MultipartFile file) {

        try {

            String fileName = file.getOriginalFilename();
            long fileSize = file.getSize();
            String contentType = file.getContentType();

            log.info("""
                    ================ FILE DETAILS ================
                    File Name    : {}
                    File Size    : {} bytes
                    Content-Type : {}
                    ==============================================
                    """, fileName, fileSize, contentType);


            Path targetLocation = fileConfig.getFileStorageLocation().resolve(fileName);

            file.transferTo(targetLocation);

            return fileName;

        } catch (IOException ex) {
            throw new FileStoreException("Could not store file", null);
        }
    }

    public Resource downloadFile(String fileName) {

        try {

            Path filePath = fileConfig.getFileStorageLocation().resolve(fileName).normalize();

            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            }

            throw new FileNotFoundException("File not found", null);

        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found", null);
        }
    }
}

