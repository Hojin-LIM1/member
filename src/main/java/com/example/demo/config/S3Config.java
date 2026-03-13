package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Bean
    public S3Client s3Client() {
        // [비기] standard() 대신 builder()를 사용하라!
        return S3Client.builder()
                .region(Region.AP_NORTHEAST_2) // 서울 리전 설정!
                .build();
    }
}