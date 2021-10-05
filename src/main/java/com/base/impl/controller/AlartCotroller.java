package com.base.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.impl.services.AlartService;


@RestController
@RequestMapping(value="/alart")
public class AlartCotroller {
	
	@Autowired
	AlartService alartService;
	
	@RequestMapping(value="/trigger")
	public String triggerAlart(@RequestParam Integer teamId) {
		return alartService.alart(teamId);
	}
	
}
