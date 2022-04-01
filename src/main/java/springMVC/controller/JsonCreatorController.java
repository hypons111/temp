package springMVC.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springMVC.model.House;


@Controller
public class JsonCreatorController {
	
	@RequestMapping(path = "/jsoncreate.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processJsonAction() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(12345);
		hBean1.setHousename("Pretty House");
		
		// House 物件轉換為 Json String
		ObjectMapper om1 = new ObjectMapper();
		String jsonStr = om1.writeValueAsString(hBean1);
		
		// Json String轉換為 House 物件
		House resultBean = om1.readValue(jsonStr, House.class);
		System.out.println(resultBean.getHouseid() + " " + resultBean.getHousename());
		
		return jsonStr;
	}
	
	// 簡單版 House 物件轉換為 Json String
	@RequestMapping(path = "/jsoncreate2.controller", method = RequestMethod.GET)
	@ResponseBody   //application/json
	public House processJsonAction2() {
		House hBean2 = new House();
		hBean2.setHouseid(1001);
		hBean2.setHousename("Yellow House");
		return hBean2;
	}
	
	// 簡單版 House 物件 ArrayList<House> 轉換為 Json String
	@RequestMapping(path = "/jsoncreate3.controller", method = RequestMethod.GET)
	@ResponseBody   
	public ArrayList<House> processJsonAction3() {
		
		House hBean1 = new House();
		hBean1.setHouseid(12345);
		hBean1.setHousename("Pretty House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1001);
		hBean2.setHousename("Yellow House");
		
		ArrayList<House> lists = new ArrayList<House>();
		lists.add(hBean1);
		lists.add(hBean2);
		
		return lists;
	}
}
