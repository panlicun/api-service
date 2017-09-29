package com.plc.service.impl;

import java.util.List;

import com.plc.domain.VedioTypeRepository;
import com.plc.service.VedioTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plc.model.VedioType;

@Service("VedioTypeService")
public class VedioTypeServiceImpl implements VedioTypeService {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private VedioTypeRepository vedioTypeRepository;

	@Override
	public List<VedioType> findAll() {
		return vedioTypeRepository.findAll();
	}
}
