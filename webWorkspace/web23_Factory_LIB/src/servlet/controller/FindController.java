package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("find_ok"); //확장자 안 넣음
		mv.addObject("message", "Hello Spring Framework!!! ,"+vo.getName());
		//라이브러리에 바인딩 기능이 있어서 attribute에 vo 바인딩 안 해도 됨...
		return mv; //null로 두지 말 것.
	}

}
