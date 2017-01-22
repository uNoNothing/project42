package com.yeti.marshaller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.yeti.dto.UserDTO;
import com.yeti.model.User;

public class UserMarshaller {

	public List<UserDTO> marshall(Iterable<User> userIterable) {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (Iterator<User> currentIterator = userIterable.iterator(); currentIterator.hasNext();) {
			userDTOList.add(marshall(currentIterator.next()));
		}

		return userDTOList;
	}

	public UserDTO marshall(User user) {
		UserDTO userDTO = new UserDTO();

		if (user != null) {
			userDTO.setUsername(user.getUsername());
			//userDTO.setPassword(user.getPassword());
			userDTO.setPassword("********");
			userDTO.setFirstname(user.getFirstname());
			userDTO.setLastname(user.getLastname());
			userDTO.setEmail(user.getEmail());
			return userDTO;
		} else {
			return null;
		}
	}

}
