package com.wook.top.front.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginFrontController {

	@RequestMapping("/login")
	public String loginMember() {

		return "main/login";
	}
}
