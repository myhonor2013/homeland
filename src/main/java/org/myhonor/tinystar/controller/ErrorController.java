package org.myhonor.tinystar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/error/error404.action")
	public String error404() {
		return "error/404";
	}

	@RequestMapping(value = "error/error500.action")
	public String error500() {
		return "error/500";
	}
}
