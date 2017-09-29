package com.plc.service;

import com.plc.model.User;

public interface UserService {
	User findUserByUserName(String userName);
}
