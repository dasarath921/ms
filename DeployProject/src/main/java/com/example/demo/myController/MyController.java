package com.example.demo.myController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/msg")
	public String getMsg() {
		return "Deploy in aws";
	}

}
