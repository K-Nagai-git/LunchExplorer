package com.example.lunchex.controller;
//★★★★★★★★★★★★
//ここは画像アップロード用コントローラーです。
//★★★★★★★★★★★★★★ 

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//作成者　糸山　1106
//メモ：
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.lunchex.service.FileService;

//@RestController
@Controller
public class FileUploadController {
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
    //public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		String newFileName = null;
		String updataOriginalFilename = file.getOriginalFilename();
		if(updataOriginalFilename != "") {
	     // 動的にアップロードディレクトリを指定
			String userHome = System.getProperty("user.home");
	        String uploadDirectory = userHome + "\\git\\LunchExplorer\\src\\main\\resources\\static\\images\\";		
	 
	        // アップロード先ディレクトリが存在してない場合、作成する
	        File directory = new File(uploadDirectory);
	        if(!directory.exists()) {
	        	directory.mkdirs();
	        }
	
	        // オリジナルファイル名から拡張子を取得
	        String originalFileName = file.getOriginalFilename();
	        String fileExtension = "";
	        if (originalFileName != null && originalFileName.contains(".")) {
	            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
	        }
	
	        // 新しいファイル名を生成（タイムスタンプを使用）
	        //String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + originalFileName + fileExtension;
	        newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + originalFileName;
	        System.out.println("アップロードしたファイル名: " + newFileName);
	
	        try {
	
	            // ファイルを指定のディレクトリに保存する処理
	            file.transferTo(new File(uploadDirectory + newFileName));
	            
	            //アップロード完了後アップロードしたファイル名を返す
	            return newFileName;
	/**↑登録時にアップロードした後に登録処理(detailsaveを実行)するためにのコード----------------------------*/
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "File upload failed!";
	        }
		}else {
			return newFileName; 
		}
    }
}
