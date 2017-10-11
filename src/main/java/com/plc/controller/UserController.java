package com.plc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plc.model.User;
import com.plc.service.UserService;
import com.plc.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.plc.util.ErrMsg;

@RestController
@RequestMapping("user")
public class UserController {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object index(HttpServletRequest request, HttpServletResponse response, User user) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		User user_table = userService.findUserByUserName(user.getUserName());
		if (user_table != null) {
			String MD5Pwd = MD5Util.string2MD5(user.getPassWord());
			if (user_table.getPassWord().equals(MD5Pwd)) {
				request.getSession().setAttribute("user", user_table);
				errMsg.setData(user_table);
				return errMsg;
			} else {
				errMsg = new ErrMsg(ErrMsg.PASSWD_INCORRECT);
				return errMsg;
			}
		} else {
			errMsg = new ErrMsg(ErrMsg.USER_NOT_EXIST);
			return errMsg;
		}
	}

	@ResponseBody
	@RequestMapping(value = "goOut", method = RequestMethod.POST)
	public Object goOut(HttpServletRequest request, HttpServletResponse response) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		// 清楚session
		request.getSession().invalidate();
		return errMsg;
	}
}
