package com.plc.service.impl;

import java.util.List;

import com.plc.model.Vedio;
import com.plc.domain.VedioRepository;
import com.plc.service.VedioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("VedioService")
public class VedioServiceImpl implements VedioService {
	// Log
	private final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private VedioRepository vedioRepository;

	@Override
	public Vedio save(Vedio vedio) {
		return vedioRepository.save(vedio);
	}

	@Override
	public Page<Vedio> findByVedioTypeId(Long vedioTypeId, Pageable pageable) {
		return vedioRepository.findByVedioTypeId(vedioTypeId, pageable);
	}

	@Override
	public Page<Vedio> findAll(Pageable pageable) {
		return vedioRepository.findAll(pageable);
	}

	@Override
	public Long countByVedioTypeId(Long vedioTypeId) {
		return vedioRepository.countByVedioTypeId(vedioTypeId);
	}

	@Override
	public Long count() {
		return vedioRepository.count();
	}

	@Override
	public Vedio findOne(Long id) {
		return vedioRepository.findOne(id);
	}

	@Override
	public void delIdList(List<Long> idList) {
		if (!idList.isEmpty() && null != idList) {
			for (Long id : idList) {
				vedioRepository.delete(id);
			}
		}
	}
	
	@Override
	public void addPlayTimes(Long id){
		Vedio vedio = vedioRepository.findOne(id);
		vedio.setPlayTimes(vedio.getPlayTimes()+1);
		vedioRepository.save(vedio);
	}
	
	@Override
	public List<Vedio> findTop20ByPlayTimes(){
		return vedioRepository.findTop20ByPlayTimes();
	}
	
	@Override
	public Page<Vedio> findByVedioNameLike(String vedioName,Pageable pageable){
		return vedioRepository.findByVedioNameLike(vedioName,pageable);
	}
	
	@Override
	public Long countByVedioNameLike(String vedioName) {
		return vedioRepository.countByVedioNameLike(vedioName);
	}

    @Override
    @Transactional
	public void test(){
        Vedio vedio = new Vedio();
        vedio.setVedioName("test1");
        vedio.setVedioTypeId(1L);
        vedio.setVedioTypeName("test1");
        vedioRepository.save(vedio);
        Vedio vedio1 = new Vedio();
        vedio1.setVedioName("test2");
        vedio1.setVedioTypeName("test2");
        vedioRepository.save(vedio1);
        Vedio vedio2 = new Vedio();
        vedio2.setVedioName("test3");
        vedio2.setVedioTypeId(1L);
        vedio2.setVedioTypeName("test3");
        vedioRepository.save(vedio2);
    }

}
