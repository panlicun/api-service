package com.plc.service.impl;

import com.plc.model.User;
import com.plc.domain.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plc.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
