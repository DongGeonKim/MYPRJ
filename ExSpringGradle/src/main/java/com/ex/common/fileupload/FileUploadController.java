package com.ex.common.fileupload;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> uploadFile(@RequestParam("name")String name, @RequestParam("file") MultipartFile[] files) {
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("name : " + name);
		try{
 			if(files != null){
				for(MultipartFile mf : files){
					if(mf != null && mf.getSize() > 0){
						String fileName = mf.getOriginalFilename();
						String fileFullPath = "C:/Users/dgkim/Desktop/file/"+fileName;
						OutputStream fos = new FileOutputStream(fileFullPath);
						fos.write(mf.getBytes());
						fos.flush();
						fos.close();
					}
				}
			}
 			map.put("result", "성공");
		}catch(Exception e){
			e.printStackTrace();
			map.put("result", "실패");
		}
		
		return map;
	}
	
	
}
