package com.bikkadit.electronicsstore.services.Impl;

import com.bikkadit.electronicsstore.exceptions.BadApiRequest;
import com.bikkadit.electronicsstore.services.FileService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private Logger logger= LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {

        String originalFilename = file.getOriginalFilename();

        logger.info("FileName:{}", originalFilename);

        String filename = UUID.randomUUID().toString();

        String extension = filename.substring(originalFilename.lastIndexOf("."));

        String fileNameWithExtension = filename + extension;
        //file path
        String fullPathWithFileName = path + fileNameWithExtension;


        if (extension.equalsIgnoreCase(".png") || extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".jpeg")) {

            // file save
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
            return fileNameWithExtension;
        } else {

            throw new BadApiRequest("File with this" + extension + "not allowed  !!");
        }
    }
    @Override
    public InputStream getResource(String path, String name) throws FileNotFoundException {
            String fullPath= path+ File.separator+ name;

            InputStream inputStream = new FileInputStream(fullPath);

        return null;
    }
}
