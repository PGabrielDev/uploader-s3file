package com.pggm.s3.imageupload.s3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.identity.spi.AwsCredentialsIdentity;
import software.amazon.awssdk.identity.spi.internal.DefaultAwsCredentialsIdentity;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Setup {
    @Bean
    public S3Client getS3Client() {
        return S3Client
                .builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                .region(Region.US_EAST_2)
                .build();
    }
}
