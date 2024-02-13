package com.demo;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;

public class BASE64DecodedMultipartFile implements MultipartFile {

    private final byte[] image;

    public BASE64DecodedMultipartFile(byte[] image) {
        this.image = image;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOriginalFilename() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (image == null)
            return true;
        else
            return false;
    }

    @Override
    public long getSize() {
        return image.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return image;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(image);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(image);
    }

}
