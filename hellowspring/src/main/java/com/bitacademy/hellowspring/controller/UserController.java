package com.bitacademy.hellowspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @RequestMapping
 *  클래스 + 메소드(핸들러) 매핑
 *  강추!
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
//	@RequestMapping(value="/joinform", method=RequestMethod.POST)
//	public String joinform() { //url만 일치
//		return "/WEB-INF/views/joinform.jsp";	
//	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() { //url만 일치
		return "/WEB-INF/views/join.jsp";	
	}
	@RequestMapping(value="/join", method=RequestMethod.POST) //*****
	public String join(UserVo userVo) { //userVo new, get, set 반복적인 것을 spring이 알아서 vo.setName(name) 이런거 자동생성
		System.out.println(userVo); //예술
		return "redirect:/";	
	}
	
	
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "UserController.list";
	}
	
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout() {
		return "UserController.list";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { // ?name= 하면 유추할 수 있어서 그냥 n으로도
		/**
		 * 만일, n이라는 이름의 파라미터가 없으면
		 * 400 bad request 에러가 발생한다.
		 */
		return "UserController.update(" + name + ")"; //n 이런 변수이름 지정xxxx
	} // n 안넣으면 400 뜨기 떄문에 default값넣엉야
	
	@ResponseBody
	@RequestMapping("/update2") //400 에러뜨면 tomcat 9.0을 쓰고 있구나를 해커에게 보여주는 꼴
	public String update2(@RequestParam(value="n", required=false) String name) {
		return "UserController.update2(" + name + ")"; 
	}
	
	@ResponseBody
	@RequestMapping("/update3") 
	public String update3(@RequestParam(value="n", required=true, defaultValue="") String name) {
		return "UserController.update3(" + name + ")";  //이러면 빈 스트림
	}
	
	@ResponseBody
	@RequestMapping("/list") //자동 형변환
	public String list(@RequestParam(value="p", required=true, defaultValue="1") int pageNo) { //
		return "UserController.list("+ pageNo +")";
	}
}
