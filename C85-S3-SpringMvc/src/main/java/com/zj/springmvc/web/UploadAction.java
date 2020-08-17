package com.zj.springmvc.web;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadAction {

	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		String dispath = "E:/images/";
		String filename = file.getOriginalFilename();// 文件名
		file.transferTo(new File(dispath + filename));
		return "success" + "    " + "photo/" + filename;

	}

}
