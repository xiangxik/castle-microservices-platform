package com.whenling.module.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.whenling.module.basic.entity.User;
import com.whenling.module.basic.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public Page<User> findAll(Predicate predicate, Pageable pageable) {
		return userRepository.findAll(predicate, pageable);
	}
}
