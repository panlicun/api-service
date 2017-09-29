package com.plc.domain;

import com.plc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String usreName);
}
