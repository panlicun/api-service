package com.plc.domain;

import java.util.List;

import com.plc.model.Vedio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VedioRepository extends JpaRepository<Vedio, Long>{
	Page<Vedio> findByVedioTypeId(Long vedioTypeId,Pageable pageable);

	@Query(value = "select * from vedio order by play_times desc limit 20", nativeQuery = true)
	List<Vedio> findTop20ByPlayTimes();
	
	Page<Vedio> findByVedioNameLike(String vedioName,Pageable pageable);

}
