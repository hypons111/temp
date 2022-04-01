package springMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class MyExceptionHandle {

	// 處理 exception 的 handler
	@ExceptionHandler(Exception.class)
	public Object exceptionHandle(Exception e) {
		String errMsg1 = "exception:Exception";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg1);
	}

}
