package springMVC.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController2 {

	// 使用 get request
	@RequestMapping(path = "/hello.controller2", method = RequestMethod.GET)
	// 等如 > String userName = request.getParameter("userName");
	public String processActionGet(@RequestParam("userName") String userName, Model m) {

		Map<String, String> errors = new HashMap<String, String>();
		// 等如 > request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return "/form.jsp";
		}

		// 等如 > HttpSession session = request.getSession();
		// 等如 > session.setAttribute("userName", userName);
		m.addAttribute("userName", userName);

		return "success";
	}
	
	// 使用 post request
	@RequestMapping(path = "/hello.controller2", method = RequestMethod.POST)
	// 等如 > String userName = request.getParameter("userName");
	public String processActionPost(@RequestParam("userName") String userName, Model m) {

		Map<String, String> errors = new HashMap<String, String>();
		// 等如 > request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return "/form.jsp";
		}

		// 等如 > HttpSession session = request.getSession();
		// 等如 > session.setAttribute("userName", userName);
		m.addAttribute("userName", userName);

		return "success";
	}
}