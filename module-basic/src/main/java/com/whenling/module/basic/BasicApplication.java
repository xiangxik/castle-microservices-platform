package com.whenling.module.basic;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.whenling.module.basic.entity.User;
import com.whenling.module.basic.repo.UserRepository;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BasicApplication.class).run(args);
	}

	@Bean
	public SmartInitializingSingleton afterStartup() {
		return new SmartInitializingSingleton() {

			@Autowired
			private UserRepository userRepository;
			
			@Autowired
			private PasswordEncoder passwordEncoder;
			
			@Override
			public void afterSingletonsInstantiated() {
				if(userRepository.count() == 0) {
					User user = new User();
					user.setUsername("admin");
					user.setPassword(passwordEncoder.encode("qwe123"));
					user.setName("管理员");
					userRepository.save(user);
				}
			}
		};
	}
}
