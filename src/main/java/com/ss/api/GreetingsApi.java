package com.ss.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsApi {

	@Autowired
	MessageSource messageSource;

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		System.out.println(LocaleContextHolder.getLocale());
		return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale()) + " " + name;
	}
}
