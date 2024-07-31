package com.kwan.app.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice ajax 요청시 exception
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NullPointerException.class)
	public void exception1() {

	}
}
