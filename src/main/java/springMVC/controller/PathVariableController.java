package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PathVariableController {

	// path="" 對應路徑
	// method = RequestMethod.[GET / POST] 指定請求方式
	@RequestMapping(path="/member/", method = RequestMethod.GET)
	// @RequestParam(name="") 參數的名稱
	public String processAction(@RequestParam(name="userName") String data) {
		System.out.println("userName : " + data);
		
		return "/pathVariable.jsp";
	}
	
	// 只能用在 http://localhost:8080/SpringMvcWebProject/member/userName=abc
	// 註: userName 之前沒有 ?
//	@RequestMapping(path = "/member/{userName}", method = RequestMethod.GET)
//	public String processAction(@PathVariable("userName") String userName) {
//		System.out.println("userName:" + userName);
//		return "/pathVariable.jsp";
//	}

	
}
