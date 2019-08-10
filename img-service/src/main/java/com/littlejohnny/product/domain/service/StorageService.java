package com.littlejohnny.product.domain.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface StorageService {

    void store(MultipartFile file) throws IOException;

    Path load(String fileName);

    Resource loadAsResource(String fileName);

    void delete(String fileName) throws IOException;
}
