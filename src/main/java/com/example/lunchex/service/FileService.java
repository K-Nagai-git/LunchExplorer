package com.example.lunchex.service;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class FileService {
	   private String uploadedFileName;

	   // ファイル名を取得
	   public String getUploadedFileName() {
	        return uploadedFileName;
	    }
	    // ファイル名を設定
	    public void setUploadedFileName(String fileName) {
	        this.uploadedFileName = fileName;
	    }
	    // ファイル名を初期化
	    public void clearUploadedFileName() {
	        this.uploadedFileName = null;
	    }
}
