package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/msg")
	public String msg() {
		return "Message from MyController Sample Project";
	}

 @GetMapping("/")
	public String msg1() {
		return "Message from  Sample Project";
	}

}
