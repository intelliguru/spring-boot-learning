package com.intelliguru.javalearning.fileops.controller;

import com.intelliguru.javalearning.fileops.service.FileProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file/v1")
@RequiredArgsConstructor
public class FileController {
    private final FileProcessingService fileProcessingService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = fileProcessingService.uploadFile(file);

        return "File uploaded successfully : " + fileName;
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {

        Resource resource =
                fileProcessingService.downloadFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + resource.getFilename()
                )
                .body(resource);
    }

}
