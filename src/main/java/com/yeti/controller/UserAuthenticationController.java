package com.yeti.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserAuthenticationController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationController.class);

	@RequestMapping(value = "/userauthentication")
	public Principal user(Principal user) {
		logger.debug("/api/userauthentication GET");
		// logger.debug(new Gson().toJson(user));
		return user;
	}
}