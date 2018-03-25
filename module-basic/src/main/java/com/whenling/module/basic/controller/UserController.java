package com.whenling.module.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.whenling.module.basic.entity.User;
import com.whenling.module.basic.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	public Page<User> doPage(Predicate predicate, Pageable pageable) {

		User user = new User();
		user.setName("Admin");
		user.setUsername("admin");
		user.setPassword("qwe123");
		userService.save(user);

		return userService.findAll(predicate, pageable);
	}

}
