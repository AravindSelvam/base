package com.base.impl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.base.impl.model.Team;


@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	Team findById(Integer id);
}
