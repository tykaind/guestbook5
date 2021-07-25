package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired
	GuestBookDao guestbookDao;
	
	//리스트
	@RequestMapping("/addList")
	public String addlist(Model model) {
		
		List<GuestBookVo> guestList = guestbookDao.getGuestBookVo();
		model.addAttribute("guestList", guestList);
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	//등록
	@RequestMapping("/add")
	public String add(GuestBookVo guestbookVo) {
		
		guestbookDao.guestInsert(guestbookVo);
		
		return "redirect:/addList";
	}
	
	//삭제폼
	@RequestMapping("/deleteForm")
	public String deleteForm(@RequestParam("no") int no,Model model) {
		System.out.println(no);
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no,@RequestParam("password") String password) {
		
		//guestbookDao.guestDelete(no, password);
		
		return "redirect:/addList";
	}
	
}
