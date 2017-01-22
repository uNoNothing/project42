package com.yeti.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.yeti.dto.Message;
import com.yeti.exception.BaseException;

@ControllerAdvice
@RestController
public class BaseController {

	@ExceptionHandler(value = BaseException.class)
	public Message handleBaseException(BaseException e) {
		Message message = new Message();
		message.setError(false);
		message.setMessage(e.getMessage());
		return message;
	}

	@ExceptionHandler(value = Exception.class)
	public Message handleException(Exception e) {
		Message message = new Message();
		message.setError(false);
		message.setMessage(e.getMessage());
		return message;
	}
}