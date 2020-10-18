package com.MattTannahill.spring_board;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetingController {

	@RequestMapping("/greeting")
	public String index() {
		return "Hello, 世界!";
	}

}