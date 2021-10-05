package com.base.impl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.base.impl.model.Developer;
import com.base.impl.model.Team;


@Repository
public interface DeveloperRepository  extends CrudRepository<Developer, Long>{
	Developer findFirstByTeamOrderByIdAsc(Team team);
}
 