package com.beauto.iiotconnx.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = " *", allowedHeaders = "*")
public class IiotConnxController {
	
	@GetMapping(value="/hello")
	public String msg() {
		return "Hello Beauto";
	}

}
