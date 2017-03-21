package com.yeti.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.dto.UsersDetailsDTO;
import com.yeti.marshaller.UsersDetailsMarshaller;
import com.yeti.repository.UsersDetailsRepository;
import com.yeti.service.UsersDetailsService;

@Service
public class UsersDetailsServiceImpl implements UsersDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UsersDetailsServiceImpl.class);

	@Autowired
	private UsersDetailsRepository usersDetailsRepository;
	private UsersDetailsMarshaller usersDetailsMarshaller = new UsersDetailsMarshaller();

	@Override
	public UsersDetailsDTO readUser(String username) {
		logger.debug("Accessing readUser(" + username + ")");
		return usersDetailsMarshaller.marshall(usersDetailsRepository.findUser(username));
	}
}