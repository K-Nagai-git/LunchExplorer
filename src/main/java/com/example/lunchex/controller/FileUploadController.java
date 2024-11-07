package com.example.lunchex.controller;
//★★★★★★★★★★★★
//ここは画像アップロード用コントローラーです。
//★★★★★★★★★★★★★★ 

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
//作成者　糸山　1106
//メモ：
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.lunchex.service.FileService;

@RestController
public class FileUploadController {
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        //String uploadDirectory = "uploads/"; // アップロード先のディレクトリを指定
        //String uploadDirectory = "C:\\Users\\3030838\\git\\LunchExplorer\\src\\main\\resources\\static\\images\\"; // アップロード先のディレクトリを指定
     // 動的にアップロードディレクトリを指定
		String userHome = System.getProperty("user.home");
        String uploadDirectory = userHome + "\\git\\LunchExplorer\\src\\main\\resources\\static\\images\\";		
     // アップロードされたファイル名を取得
 //       String fileName = file.getOriginalFilename();
//        System.out.println("アップロードしたファイル名" + fileName);

        // オリジナルファイル名から拡張子を取得
        String originalFileName = file.getOriginalFilename();
        String fileExtension = "";
        if (originalFileName != null && originalFileName.contains(".")) {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        }

        // 新しいファイル名を生成（タイムスタンプを使用）
        String newFileName = originalFileName  + "_" +new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileExtension;
        System.out.println("アップロードしたファイル名: " + newFileName);

        try {
//            // ファイルを指定のディレクトリに保存
//        	file.transferTo(new File(uploadDirectory + file.getOriginalFilename()));
//            return "File uploaded successfully!";
        	// 新しいファイル名で保存
            file.transferTo(new File(uploadDirectory + newFileName));
            
            // FileServiceにアップロードされたファイル名を設定
            fileService.setUploadedFileName(newFileName);
            return "File uploaded successfully as " + newFileName + "!";
            
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed!";
        }
    }
}
