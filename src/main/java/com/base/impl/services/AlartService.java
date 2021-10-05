package com.base.impl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.impl.model.Developer;
import com.base.impl.model.Team;
import com.base.impl.repository.DeveloperRepository;
import com.base.impl.repository.TeamRepository;


@Service
public class AlartService {
	
	@Autowired
	private DeveloperRepository developerRepo;
	
	@Autowired
	private TeamRepository teamRepository;
	
	public String alart(Integer teamId) {
		Team team = teamRepository.findById(teamId);
		if(team==null) {
			return "Team not found "+teamId;
		}
		
		Developer developer = developerRepo.findFirstByTeamOrderByIdAsc(team);
		
		if(developer==null) {
			return "developer not found "+teamId;
		}
		
		triggerNotification(developer.getPhoneNumber(),"dummy msg");
		
		return "alart triggerd";
	}

	private void triggerNotification(String phoneNumber, String string) {
		
	}
}
