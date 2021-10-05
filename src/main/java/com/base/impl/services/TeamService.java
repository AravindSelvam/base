package com.base.impl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.impl.model.Developer;
import com.base.impl.model.Team;
import com.base.impl.pojo.TeamDetails;
import com.base.impl.pojo.TeamRequest;
import com.base.impl.repository.DeveloperRepository;
import com.base.impl.repository.TeamRepository;


@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	

	@Autowired
	private DeveloperRepository developerRepo;
	
	
	public void createTeam(TeamRequest request) {
//		todo
		validate(request);
		
		Team team = new Team();
		team.setName(request.getTeam().getName());

		teamRepository.save(team);

		for (TeamDetails dev : request.getDevelopers()) {
			Developer newDeveloper = new Developer();
			newDeveloper.setTeam(team);
			newDeveloper.setName(dev.getName());
			newDeveloper.setPhoneNumber(dev.getPhone_number());
			developerRepo.save(newDeveloper);
		}

	}


	private void validate(TeamRequest request) {
		
	}
	
}
