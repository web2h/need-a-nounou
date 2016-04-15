package com.web2h.nan.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web2h.nan.core.service.UserService;
import com.web2h.nan.model.entity.user.User;

@RestController
@RequestMapping("/")
public class TestController {

	@Autowired
	private UserService userService;

	@Value("${rest.authentication.salt}")
	private String salt;

	@RequestMapping("/hello/{player}")
	public ResponseEntity<Message> sayHello(@PathVariable String player) {
		User user = userService.getUser();
		Message msg = new Message(player, "Hello 2 " + player + " " + user.getName());
		return new ResponseEntity<Message>(msg, HttpStatus.UNAUTHORIZED);
	}
}