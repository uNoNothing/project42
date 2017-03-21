package com.yeti.marshaller;

import com.yeti.dto.UsersDetailsDTO;
import com.yeti.model.UsersDetails;

public class UsersDetailsMarshaller {

	public UsersDetailsDTO marshall(UsersDetails usersDetails) {
		UsersDetailsDTO usersDetailsDTO = new UsersDetailsDTO();

		if (usersDetails != null) {
			usersDetailsDTO.setUsername(usersDetails.getUsers().getUsername());
			usersDetailsDTO.setFirstname(usersDetails.getFirstname());
			usersDetailsDTO.setLastname(usersDetails.getLastname());
			usersDetailsDTO.setEmail(usersDetails.getEmail());

			return usersDetailsDTO;
		} else {
			return null;
		}
	}
}