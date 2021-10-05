package com.base.impl.pojo;

import java.util.List;

public class TeamRequest {
	
	TeamDetails team;
	List<TeamDetails> developers;
	
	public TeamDetails getTeam() {
		return team;
	}
	public void setTeam(TeamDetails team) {
		this.team = team;
	}
	public List<TeamDetails> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<TeamDetails> developers) {
		this.developers = developers;
	}
	
	
}
