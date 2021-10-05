package com.base.impl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.impl.pojo.TeamRequest;
import com.base.impl.services.TeamService;


@RestController
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/create")
	public Map<String, String> createTeam(@RequestBody  TeamRequest request){
		return teamService.createTeam(request);
	}
}
