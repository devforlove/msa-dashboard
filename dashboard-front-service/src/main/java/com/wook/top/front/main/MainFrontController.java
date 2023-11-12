package com.wook.top.front.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainFrontController {

	@RequestMapping("/")
	public String mainDashboard() {

		return "main/home";
	}
}
