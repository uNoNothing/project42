package com.yeti.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yeti.dto.Message;
import com.yeti.dto.UserDTO;
import com.yeti.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/read/users", method = RequestMethod.GET)
	public List<UserDTO> readUsers() {
		logger.info("Get all users from database");
		logger.debug("/api/read/users GET");
		return userService.readUsers();
	}

	@RequestMapping(value = "/read/user/{username}", method = RequestMethod.GET)
	public UserDTO readUser(@PathVariable String username) {
		logger.info("Get user: " + username + " from database");
		logger.debug("/api/read/user/" + username + " GET");
		return userService.readUser(username);
	}

	@RequestMapping(value = "/update/user", method = RequestMethod.PUT)
	public Message updateUser(@Valid @RequestBody UserDTO userDTO) {
		logger.info("Update user: " + userDTO.getUsername() + " in database");
		logger.debug("/api/update/user PUT");
		return userService.updateUser(userDTO);
	}

	@RequestMapping(value = "/create/user", method = RequestMethod.POST)
	public Message createUser(@Valid @RequestBody UserDTO userDTO) {
		logger.info("Create user: " + userDTO.getUsername() + " in database");
		logger.debug("/api/create/user POST");
		return userService.createUser(userDTO);
	}

	@RequestMapping(value = "/delete/user/{username}", method = RequestMethod.DELETE)
	public Message deleteUser(@PathVariable String username) {
		logger.info("Delete user: " + username + " from database");
		logger.debug("/api/delete/user/" + username + " DELETE");
		return userService.deleteUser(username);
	}

}
