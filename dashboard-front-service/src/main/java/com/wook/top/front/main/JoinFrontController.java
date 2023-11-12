package com.wook.top.front.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinFrontController {

	@RequestMapping("/join")
	public String joinMember() {

		return "main/join";
	}
}
