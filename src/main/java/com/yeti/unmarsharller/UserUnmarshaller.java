package com.yeti.unmarsharller;

import com.yeti.dto.UserDTO;
import com.yeti.model.User;

public class UserUnmarshaller {

	public User unmarshall(UserDTO userDTO) {
		User user = new User();

		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());

		return user;
	}
}
