package com.kob.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.encode("123456"));
		System.out.println(passwordEncoder.matches("123456", "$2a$10$.vt8clL1VU/lVIVU4DuaS.HfOtp4EMyyilC6Dz0qg3LfFBpvcF7Xi"));
	}

}
