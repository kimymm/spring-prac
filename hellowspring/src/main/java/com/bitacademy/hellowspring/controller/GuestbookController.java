package com.bitacademy.hellowspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @RequestMapping
 *  클래스 단독 매핑
 *  Spring MVC 4.0 에서만 지원! 
 *  Spring MVC 5.x 이상에서는 사용 금지
 *  requestmapping을 클래스에 지원
 */

// Spring MVC 5.x이상 오류
//@Controller
@RequestMapping("/guestbook/*") //class단독매핑 /guestbook/list
public class GuestbookController {
	
	@ResponseBody //테스트목적,화면에 바로 출력목적
	@RequestMapping// 있어야 이 메소드가 핸들러가 됨 없으면 일반메소드("")만 안함
	public String list() {
		return "GuestbookController.list()";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController.delete()";
	}
}
