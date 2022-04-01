package springMVC.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

	// 回傳 json 格式頁面
	@RequestMapping(path = "/response.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processResponseAction() {
		return "This Message is from Server.";
	}

	// 回傳 中文 json 格式頁面
	@RequestMapping(path = "/responsecharset.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processCharsetResponseAction() {
		return "菊花的味道";
	}

	// 回傳 entity
	@RequestMapping(path = "/responseentity.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseEntityAction() {
		return new ResponseEntity<String>("Custom Status Code(403 Forbidden)", HttpStatus.FORBIDDEN);
	}

	// 回傳 加了 header 的 entity
	@RequestMapping(path = "/responseentitywithheaders.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseEntityHeadersAction() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("ResponseEntity With Headers", headers, HttpStatus.FORBIDDEN);
	}
	
	// 回傳圖片
	@RequestMapping(path = "/responseimage.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void processResponseImageAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/orz.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}
	
	// 可下載回傳圖片
	@RequestMapping(path = "/responseimagetobytearray.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processResponseImageToByteArrayAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/orz.jpg");
		return IOUtils.toByteArray(is1);
	}
}
