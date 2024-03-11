package com.nurmatov.mindhunter.service;

import com.nurmatov.mindhunter.domain.entity.userInfo.Image;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image uploadFile(MultipartFile file);

    void uploadFileToS3Bucket(MultipartFile file);

    byte[] downloadFile(String fileName);

    void deleteFile(Long id);

    Image showById(Long id);
}
