package com.bitacademy.hellowspring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; // +	

@Controller //어노테이션, 표식
public class HelloController {
	
	// 모델넘기는방식 3+가지
	@RequestMapping("/hello") //요청에 대한 매핑 /hello를 controller에게 분기
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; //아 포워드구나
	}
	@RequestMapping("/hello2") //요청에 대한 매핑 /hello를 controller에게 분기
	public String hello2(String name) {
		System.out.println("name:" + name);
		return "/WEB-INF/views/hello.jsp"; //아 포워드구나
	}
	@RequestMapping("/hello3") //요청에 대한 매핑 /hello를 controller에게 분기
	public ModelAndView hello(String name) { //************
		ModelAndView mav = new ModelAndView(); //jsp로 넘길려면 사용
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav; 
	}
	@RequestMapping("/hello4") //데이터 넘길때 이방식을 추천***********
	public String hello4(String name, Model model) { //************
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	@ResponseBody //hello출력
	@RequestMapping("/hello5") //ajax
	public String hello5() {
		return "<h1>Hello ㅁㅁㅁㅁWorld</h1>"; //404
	}
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello";
	}
	@RequestMapping("/hello7")
	public void hello7( //기술침투 기술, 절대사용xxxxxx
			HttpServletRequest request,
			HttpServletResponse response,
			Writer out) throws IOException { //기술비침투에 대한 컨셉자체를 모르는 않좋은코드
		String name = request.getParameter("name");
		out.write("helloaa" + name);
	}
}
