package com.whenling.module.authserver;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://tools.ietf.org/html/rfc6749#section-4.1
@SpringBootApplication
@RestController
public class AuthserverApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AuthserverApplication.class).run(args);
	}

	@RequestMapping("/message")
	public Map<String, Object> dashboard() {
		return Collections.<String, Object>singletonMap("message", "Yay!");
	}

	@RequestMapping(value = "/user", produces = "application/json")
	public Principal user(Principal user) {
		return user;
	}
}
