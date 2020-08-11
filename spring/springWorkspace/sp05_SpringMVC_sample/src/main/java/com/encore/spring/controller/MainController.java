package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();//뷰페이지이름, 이동경로지정, 데이타
		//mv.setViewName("WEB-INF/result.jsp");ViewResolver를 안쓰면 이렇게 경로랑 확장자 다 써줘야한다. 
		mv.setViewName("result");// 확장자 안씀...물리적인 저장위치----> ViewResolver
		mv.addObject("message", "Hello First SpringMVC!!!");
		return mv;
	}

}
