package com.yeti.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yeti.dto.Message;
import com.yeti.dto.UserDTO;
import com.yeti.marshaller.UserMarshaller;
import com.yeti.model.User;
import com.yeti.repository.UserRepository;
import com.yeti.service.UserService;
import com.yeti.unmarsharller.UserUnmarshaller;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	private UserMarshaller userMarshaller = new UserMarshaller();
	private UserUnmarshaller userUnmarshaller = new UserUnmarshaller();

	@Override
	public List<UserDTO> readUsers() {
		logger.debug("readUsers()");
		return userMarshaller.marshall(userRepository.findAll());
	}

	@Override
	public UserDTO readUser(String username) {
		logger.debug("readUser()");
		return userMarshaller.marshall(userRepository.findByUsername(username));
	}

	@Override
	public Message updateUser(UserDTO userDTO) {
		logger.debug("updateUser()");
		UserDTO userDTOFromDatabase = readUser(userDTO.getUsername());
		logger.debug("userDTOFromDatabase: " + new Gson().toJson(userDTOFromDatabase));
		logger.debug("userDTO: " + new Gson().toJson(userDTO));
		Message message = new Message();
		String returnMessage = "";
		if (userDTOFromDatabase == null) {
			message.setError(false);
			returnMessage = "User not found";
			logger.debug(returnMessage);
			message.setMessage(returnMessage);
		} else if (userDTO.equals(userDTOFromDatabase)) {
			message.setError(false);
			returnMessage = "No change detected";
			logger.debug(returnMessage);
			message.setMessage(returnMessage);
		} else {
			User user = userUnmarshaller.unmarshall(userDTO);
			userRepository.updateByUsername(user.getUsername(), user.getPassword(), user.getFirstname(),
					user.getLastname(), user.getEmail());
			message.setError(true);
			returnMessage = "User: " + userDTO.getUsername() + " updated";
			logger.debug(returnMessage);
			message.setMessage(returnMessage);
			userDTO.setPassword("********");
			message.setObject(userDTO);

		}
		return message;
	}

	@Override
	public Message createUser(UserDTO userDTO) {
		logger.debug("createUser()");
		Message message = new Message();
		String returnMessage = "";

		User user = userUnmarshaller.unmarshall(userDTO);
		User savedUser = userRepository.save(user);

		returnMessage = "User: " + user.getUsername() + " saved in database";
		logger.debug(returnMessage);
		message.setError(true);
		message.setMessage(returnMessage);
		savedUser.setPassword("********");
		message.setObject(savedUser);

		return message;
	}
	
	@Override
	public Message deleteUser(String username){
		logger.debug("deleteUser()");
		Message message = new Message();
		String returnMessage = "";
		
		UserDTO userDTOFromDatabase = readUser(username);
		if (userDTOFromDatabase == null) {
			message.setError(false);
			returnMessage = "User not found";
			logger.debug(returnMessage);
			message.setMessage(returnMessage);
		} else {
			userRepository.deleteByUsername(username);
			returnMessage = "User: " + username + " deleted from database";
			logger.debug(returnMessage);
			message.setError(true);
			message.setMessage(returnMessage);
		}
		return message;
	}

}
