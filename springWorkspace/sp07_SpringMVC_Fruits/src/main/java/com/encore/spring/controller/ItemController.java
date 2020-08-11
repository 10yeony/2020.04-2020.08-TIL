package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemCatalog;

@Controller
public class ItemController {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("itemList.do")
	public ModelAndView getItemList() throws Exception{
		List<Item> list = itemCatalog.getAllItem();
		return new ModelAndView("itemList", "list", list);
	}
	
	@RequestMapping("itemView.do")
	public ModelAndView getItem(int itemnumber) throws Exception{
		Item item = itemCatalog.getItem(itemnumber);
		return new ModelAndView("itemView", "item", item);
	}
}
