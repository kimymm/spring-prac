package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class EmaillistController {
	@Autowired
	private GuestbookRepository emaillistRepository;
	@ResponseBody
	@RequestMapping("/")
	public String list() {
		return "list!!";
	}
	@ResponseBody //*******************
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "/WEB-INF/views/add.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
