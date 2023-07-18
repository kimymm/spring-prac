package com.bitacademy.hellowspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @RequestMapping
 *  메소드(핸들러) 단독 매핑
 */
@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}
	
	@ResponseBody						//잘못된 예
	@RequestMapping("/board/view")
	public String view() {
		return "BoardController.view()";
	}
	
	@ResponseBody					//구식	
	@RequestMapping("/board/view?no=10")
	public String view(@RequestParam(value="no", required=true, defaultValue="0") Long no) {
		return "BoardController.view(" + no + ")";
	}
	
	@ResponseBody				
	@RequestMapping("/board/{no}")
	public String view2(@PathVariable("no") Long no) {// 예상 외 많이 사용하는 pathvariable
		return "BoardController.view2(" + no + ")";
	}
}
