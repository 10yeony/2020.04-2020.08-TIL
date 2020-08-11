package com.encore.spring.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//MultipartFile + 기타 폼정보
public class MultiFileVO {
	private String userName;
	private List<MultipartFile> file; //변수명 중요... 입력폼 name으로 똑같이 해줘야 함.
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
}
