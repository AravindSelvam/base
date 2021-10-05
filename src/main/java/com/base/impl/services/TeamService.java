package com.base.impl.services;

import java.util.HashMap;
import java.util.Map;

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
	
	
	public Map<String, String> createTeam(TeamRequest request) {
//		todo
		validate(request);

		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "success");
		try {
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
		} catch (Exception e) {
			map.put("status", "failed");
			e.printStackTrace();
		}

		return map;

	}


	private void validate(TeamRequest request) {
		
	}
	
}
