package com.yeti.service;

import java.util.List;

import com.yeti.dto.Message;
import com.yeti.dto.UserDTO;

public interface UserService {
	
	public List<UserDTO> readUsers();

	public UserDTO readUser(String username);

	public Message updateUser(UserDTO userDTO);

	public Message createUser(UserDTO userDTO);

	public Message deleteUser(String username);

}
