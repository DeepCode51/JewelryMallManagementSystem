package com.test.tool;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadTool {
    public static String upload(MultipartFile multipartFile) throws IOException {
        String newImageName = null;
        if (!multipartFile.isEmpty()){
            String realPath = "D:\\IDEA\\Hello\\Testdemo\\src\\main\\webapp\\img\\";
            String originImageName = multipartFile.getOriginalFilename();
            String uuRanName = UUID.randomUUID().toString();
            newImageName = uuRanName + originImageName.substring(originImageName.lastIndexOf("."));
            File file = new File(realPath+newImageName);
            multipartFile.transferTo(file);
        }
        return newImageName;
    }

    public static String upload(MultipartFile multipartFile, String url) throws IOException {
        String newImageName = null;
        if (!multipartFile.isEmpty()){
            String realPath = url;
            String originImageName = multipartFile.getOriginalFilename();
            String uuRanName = UUID.randomUUID().toString();
            newImageName = uuRanName + originImageName.substring(originImageName.lastIndexOf("."));
            File file = new File(realPath+newImageName);
            multipartFile.transferTo(file);
        }
        return newImageName;
    }
}
