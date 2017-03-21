package com.yeti.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserAuthController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);

	@RequestMapping(value = "/userauth", method = RequestMethod.GET)
	public Principal user(Principal user) {
		logger.debug("/api/userauth GET");
		// logger.debug(new Gson().toJson(user));
		return user;
	}
}