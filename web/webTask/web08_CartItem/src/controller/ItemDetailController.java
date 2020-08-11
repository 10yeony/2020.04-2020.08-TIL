package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDao;

public class ItemDetailController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("id"));
		boolean result = ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		Item item = ItemDao.getInstance().getItem(itemnum);
		System.out.println("Item : "+item);
		
		/*
		 *내가 작성한 코드 관련
		int count = ItemDao.getInstance().getItem(itemnum).getCount() + 1;
		Item vo = ItemDao.getInstance().updateCount(itemnum, count);
		*/
		
		//////////////////오늘 본 상품정보를 저장하는 쿠키 로직을 추가////////////
		// 1) 쿠키 생성  +  2) 생성한 쿠키를 웹 브라우저로 보냄.
		Cookie cookie = new Cookie("fruitshop"+itemnum, item.getUrl()); 
		//다른 데서 생성된 쿠키들과 구분하기 위해서 앞에 "fruitshop"을 붙여준다.
		cookie.setMaxAge(24*60*60); //시간을 하루로 설정
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemDetail.jsp");
	}

}
