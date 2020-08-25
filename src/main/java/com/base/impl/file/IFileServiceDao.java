package com.base.impl.file;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.base.impl.model.ProcessDetails;

@Transactional
public interface IFileServiceDao extends CrudRepository<ProcessDetails, Integer> {

}
