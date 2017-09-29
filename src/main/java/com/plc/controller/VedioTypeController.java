package com.plc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plc.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plc.model.VedioType;
import com.plc.service.VedioTypeService;
import com.plc.util.ErrMsg;

@RestController
@RequestMapping("/vedioType")
public class VedioTypeController {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private VedioTypeService vedioTypeService;

	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public Object index(HttpServletRequest request,HttpServletResponse response,User user) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		List<VedioType> vedioTypeList = vedioTypeService.findAll();
		if(vedioTypeList == null){
			errMsg = new ErrMsg(ErrMsg.RECORD_NOT_EXIST);
			return errMsg;
		}else{
			errMsg = new ErrMsg(ErrMsg.SUCCESS);
            errMsg.setData(vedioTypeList);
            return errMsg;
		}
	}
}
