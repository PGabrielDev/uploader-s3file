package com.pggm.s3.imageupload.useCases;

import com.pggm.s3.imageupload.useCases.interfaces.IUploaderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.MultipartUpload;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploaderUseCase implements IUploaderUseCase {

    private final S3Client s3Client;

    @Override
    public void execute(MultipartFile input) throws IOException {
        final var f =  new File(input.getName());
        log.info("Iniciando subida de Arquivo");
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket("")
                        .key("")
                        .build(),
                f.toPath()
        );
        log.info("Subida de arquivo finalizada com sucesso");
    }
}
