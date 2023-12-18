package com.pggm.s3.imageupload.Api.controllers;

import com.pggm.s3.imageupload.Api.UploaderApi;
import com.pggm.s3.imageupload.useCases.UploaderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UploaderController implements UploaderApi {

    private final UploaderUseCase uploaderUseCase;
    @Override
    public ResponseEntity<Void> uploader(MultipartFile image) {
        try {
            uploaderUseCase.execute(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.noContent().build();
    }
}
