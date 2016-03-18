package com.web2h.nan.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	
	@Value("${rest.authentication.salt}")
	private String salt;

	@RequestMapping("/hello/{player}")
	public ResponseEntity<Message> sayHello(@PathVariable String player) {	
		Message msg = new Message(player, "Hello 2 " + player + " " + salt);
		return new ResponseEntity<Message>(msg, HttpStatus.UNAUTHORIZED);
	}
}