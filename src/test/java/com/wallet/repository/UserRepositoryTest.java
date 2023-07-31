package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@BeforeAll
	public void setUp() {
		
		User user = new User();	
		
		user.setName("Set up User");
		user.setPassword("Senha123");
		user.setEmail(EMAIL);
		
		repository.save(user);
		
	}
	
	@AfterAll
	public void tearDown () {
		
		repository.deleteAll();
		
	}
	
	@Test
	private void testeSave() {
		
		User user = new User();
		
		user.setName("Test");
		user.setPassword("123456");
		user.setEmail("test@test.com");
		
		User response = repository.save(user);
		
		assertNotNull(response);
		
	}
	
	public void testFindByEmail() {
		
		Optional<User> response = repository.findByEmail(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
		
	}
	
}
