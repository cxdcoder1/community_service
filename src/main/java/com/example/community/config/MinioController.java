package com.example.community.config;

import com.example.community.utils.MinioUtilS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class MinioController {
    @Autowired
    private MinioUtilS minioUtilS;
    @Value("${minio.endpoint}")
    private String address;
    @Value("${minio.bucketName}")
    private String bucketName;

    @PostMapping("/upload")
    public Object upload(MultipartFile file) {
       
        List<String> upload = minioUtilS.upload(new MultipartFile[]{file});

        return address+"/"+bucketName+"/"+upload.get(0);
    }

}