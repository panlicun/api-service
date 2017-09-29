package com.plc;

import com.plc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.plc.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywebApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		User u1 = new User();
//		u1.setName("aa@126.com");
//		u1.setPassword("123456");
//		userRepository.save(u1);

	}


}
