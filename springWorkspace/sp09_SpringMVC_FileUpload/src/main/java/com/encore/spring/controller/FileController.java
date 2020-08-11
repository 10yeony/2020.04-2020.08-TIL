package com.encore.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.UploadDataVO;

@Controller
public class FileController {
	
	//Upload
	@RequestMapping("fileUpload.do")
	public ModelAndView fileUpload(HttpServletRequest request, UploadDataVO vo) throws IOException {
		
		//1. vo에서 MultipartFile을 받아온다...
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile :: "+mFile);
		
		/*
		 * 2. 업로드된 파일이 있다면,
		 * 		파일의 사이즈
		 * 		업로드한 파일의 이름
		 * 		업로드한 파일의 파라미터명?
		 * 		--> 파일을 서버에 올리고 싶다...
		 * 
		 * 업로드된 파일이 없다면,
		 */
		
		if(!mFile.isEmpty()) { //업로드된 파일이 있다면
			System.out.println("파일의 사이즈 :: "+mFile.getSize());
			System.out.println("업로드된 파일명 :: "+mFile.getOriginalFilename());
			
			/* <input type="file" name="uploadFile"><p> */
			/* uploadFile이 출력됨 */
			System.out.println("파일의 파라미터명 :: "+mFile.getName()); 
		}
		
		//getRealPath() - 세션이 가지고 있음.
		//HttpSession을 파라미터로 넣을 수도 있지만, HttpServletRequest가 request, session을 둘 다 다룰 수 있음.
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		//window는 \\, OS에 따라 다름. separate라는 것을 써주면 됨. 나중에 해보세요~
		
		//File은 디렉토리+파일명
		File copyFile = new File(path + mFile.getOriginalFilename());
		mFile.transferTo(copyFile); //원래 업로드한 파일이 지정한 path 위치로 이동... 이 때 카피본이 이동한다.
		System.out.println("path :: "+path);
		
		return new ModelAndView("upload_result", "uploadfile", mFile.getOriginalFilename());
	}
	
	//Download
	@RequestMapping("fileDown.do")
	public ModelAndView fileDown(HttpServletRequest request, String filename) throws IOException {
		//인자값 폼의 이름으로 똑같이 넣든지, 넘어오는 key의 이름으로 똑같이 해줘야 함.
		
		System.out.println("filename :: "+filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path); //upload한 파일을 특정한 경로에 이동... 그걸 다운로드 할 거다...
		
		return new ModelAndView("downloadView", map);
	}
}