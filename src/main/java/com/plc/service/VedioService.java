package com.plc.service;

import java.util.List;

import com.plc.model.Vedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

public interface VedioService {
	Vedio save(Vedio vedio);
	
	Page<Vedio> findByVedioTypeId(Long vedioTypeId,Pageable pageable);

	Page<Vedio> findAll(Pageable pageable);

    Vedio findOne(Long id);

	void delIdList(List<Long> idList);

	void addPlayTimes(Long id);

	List<Vedio> findTop20ByPlayTimes();

	Page<Vedio> findByVedioNameLike(String vedioName, Pageable pageable);

	void test();

}
