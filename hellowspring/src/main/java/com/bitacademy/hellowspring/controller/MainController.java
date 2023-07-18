package com.bitacademy.hellowspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@RequestMapping({"/", "/main", "a/b/c/main"}) //다중 매핑도 가능 
	public String main() {					//url 잡는 것도 구조적으로 잘잡아야
		return "MainController.main()";
	}
}
