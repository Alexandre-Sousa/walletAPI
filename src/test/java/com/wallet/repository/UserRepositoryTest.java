package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.User;

@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	
	@Test
	private void testeSave() {
		
		User user = new User();
		
		user.setName("Test");
		user.setPassword("123456");
		user.setEmail("test@test.com");
		
		User response = repository.save(user);
		
		assertNotNull(response);
		
	}
}
