package com.whenling.module.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.whenling.module.basic.entity.User;
import com.whenling.module.basic.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public Page<User> doPage(Predicate predicate, Pageable pageable) {
		System.out.println("cc");
		User user = new User();
		user.setName("Admin2");
		user.setUsername("admin2");
		user.setPassword("qwe123");
		userService.save(user);

		return userService.findAll(predicate, pageable);
	}

}
