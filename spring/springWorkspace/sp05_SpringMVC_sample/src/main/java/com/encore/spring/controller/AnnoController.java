package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
  	어노테이션을 쓰면 POJO로 만들면 됨.(DAO, Service는 아님)
	implements를 안 하면 Overriding을 못함.. 
	그러면 메소드 마음대로 쓸 수 있고, 리턴 타입도 맘대로 할 수 있음.
	
	제약 조건이 없다 = 자유롭다!
	POJO가 그만큼 강력함. 확장성이 어마어마함.
 */
@Controller
public class AnnoController {
	
	//Annotation으로 Bean 생성했으므로, mvcbean.xml에 따로 사용자 정의 Bean 등록하지 않아도 된다.
	//그리고 들어온 요청 또한 Annotation으로 명시해준다.
	@RequestMapping("anno.do")
	public ModelAndView anno() {
		return new ModelAndView("anno_result", "info", "Annotation Good~~!!");
	}
}
