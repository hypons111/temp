package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//定義為 controller
@Controller
@RequestMapping(path = "/action")  //localhost:8080/SpringMvcWebProject/action/action.controller
public class ActionController {

	// 網址 path="/action.controller", 請求方法 method = RequestMethod.GET
	@RequestMapping(path = "/action.controller", method = RequestMethod.GET)
	// 就會去到下面的網頁
	public String processAction(Model m) {
		// 等如 > request.setAttribute("info","nice day");
		m.addAttribute("info", "nice day");
//		return "/actionResult.jsp";
		return "actionResult";
	}
}
