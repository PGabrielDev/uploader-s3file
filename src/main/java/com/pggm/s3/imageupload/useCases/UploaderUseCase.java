package com.pggm.s3.imageupload.useCases;
import com.pggm.s3.imageupload.useCases.interfaces.IUploaderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploaderUseCase implements IUploaderUseCase {

    private final S3Client s3Client;

    @Override
    public void execute(MultipartFile input) throws IOException {
        Map<String, String> envs = System.getenv();

        String bucket = envs.get("AWS_BUCKET_NAME");
        log.info("Iniciando subida de Arquivo");
        String key = UUID.randomUUID() + "/" + input.getOriginalFilename();
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(key)
                        .build(),
                RequestBody.fromInputStream(input.getInputStream(),input.getSize())
        );
        log.info("Subida de arquivo finalizada com sucesso");
        RequestHandler
    }

    private String generateS3FileUrl(String bucketName, String key) {
        return "https://" + bucketName + ".s3.amazonaws.com/" + key;
    }
}
