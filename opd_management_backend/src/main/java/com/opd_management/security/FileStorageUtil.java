package com.opd_management.security;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileStorageUtil {

	@Value("${file.upload-dir}")
	private String uploadDir;
	
	public String saveFile(MultipartFile file) {
		
		try {
			
			String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			Path uploadPath = Paths.get(uploadDir);
			
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
			
			return filePath.toString();
			
		} catch (Exception e) {
			
			throw new RuntimeException("Failed to store file", e);
		}
	}

}
