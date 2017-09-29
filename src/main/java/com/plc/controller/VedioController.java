package com.plc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.plc.model.Vedio;
import com.plc.service.VedioService;
import com.plc.util.ErrMsg;
import com.plc.vo.PageVo;

@RestController
@RequestMapping("/vedio")
public class VedioController {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private VedioService vedioService;

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Object index(HttpServletRequest request, HttpServletResponse response, Vedio vedio) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		log.info(vedio.toString());
		Vedio vedio_t = vedioService.save(vedio);
		if (null != vedio_t) {
			log.info("保存成功");
			errMsg = new ErrMsg(ErrMsg.SUCCESS);
			errMsg.setData(vedio_t);
			return errMsg;
		} else {
			log.info("保存失败");
			return new ErrMsg(ErrMsg.DB_INSERT_EXCEPTION);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/pageVedio", method = RequestMethod.POST)
	public Object pageVedio(HttpServletRequest request, HttpServletResponse response, PageVo pageVo) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(pageVo.getPageId() - 1, pageVo.getPageSize(), sort);
		Page pageVedio = null;
		if (pageVo.getVedioTypeId() == 0) {
			pageVedio = vedioService.findAll(pageable);
		} else {
			pageVedio = vedioService.findByVedioTypeId(pageVo.getVedioTypeId(), pageable);
		}
		return pageVedio;
	}

	@ResponseBody
	@RequestMapping(value = "/countByVedioTypeId", method = RequestMethod.POST)
	public Object countByVedioTypeId(HttpServletRequest request, HttpServletResponse response, Long vedioTypeId) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		Long count = 0L;
		if (vedioTypeId == 0) {
			count = vedioService.count();
		} else {
			count = vedioService.countByVedioTypeId(vedioTypeId);
		}
		errMsg.setData(count);
		return errMsg;
	}

	@ResponseBody
	@RequestMapping(value = "/findOne", method = RequestMethod.POST)
	public Object findOne(HttpServletRequest request, HttpServletResponse response, Long id) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		Vedio vedio = vedioService.findOne(id);
		if (null == vedio) {
			errMsg = new ErrMsg(ErrMsg.RECORD_NOT_EXIST);
			return errMsg;
		} else {
			errMsg = new ErrMsg(ErrMsg.SUCCESS);
			errMsg.setData(vedio);
			return errMsg;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public Object deleteAll(HttpServletRequest request, HttpServletResponse response, String str) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		List<String> idList = new ArrayList<String>();
		List<Long> idList_L = new ArrayList<>();
		String[] idArr = str.split(",");
		Collections.addAll(idList, idArr);
		for (String id : idList) {
			idList_L.add(Long.parseLong(id));
		}
		vedioService.delIdList(idList_L);
		return errMsg;
	}

	@ResponseBody
	@RequestMapping(value = "/addPlayTimes", method = RequestMethod.POST)
	public Object addPlayTimes(HttpServletRequest request, HttpServletResponse response, Long id) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		vedioService.addPlayTimes(id);
		return errMsg;
	}

	@ResponseBody
	@RequestMapping(value = "/findTop20ByPlayTimes", method = RequestMethod.POST)
	public Object findTop20ByPlayTimes(HttpServletRequest request, HttpServletResponse response) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		List<Vedio> vedioList = vedioService.findTop20ByPlayTimes();
		if (null != vedioList && !vedioList.isEmpty()) {
			errMsg.setData(vedioList);
			return errMsg;
		} else {
			errMsg = new ErrMsg(ErrMsg.RECORD_NOT_EXIST);
			return errMsg;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findByVedioNameLike", method = RequestMethod.POST)
	public Object findByVedioNameLike(HttpServletRequest request, HttpServletResponse response, PageVo pageVo) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(pageVo.getPageId() - 1, pageVo.getPageSize(), sort);
		Page pageVedio = vedioService.findByVedioNameLike("%"+pageVo.getVedioName()+"%", pageable);
		return pageVedio;
	}
	
	@ResponseBody
	@RequestMapping(value = "/countByVedioNameLike", method = RequestMethod.POST)
	public Object countByVedioNameLike(HttpServletRequest request, HttpServletResponse response, String vedioName) {
		ErrMsg errMsg = new ErrMsg(ErrMsg.SUCCESS);
		Long count = 0L;
		count = vedioService.countByVedioNameLike("%"+vedioName+"%");
		errMsg.setData(count);
		return errMsg;
	}
}
