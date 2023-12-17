package com.pggm.s3.imageupload.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("s3-uploader")
public interface UploaderApi {


    @PostMapping
    ResponseEntity<Void> uploader(
            @RequestParam("image") MultipartFile image
    );

}
