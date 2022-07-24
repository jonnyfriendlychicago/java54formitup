package com.jonfriend.java54formitup.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java54formitup.models.DojoMdl;

@Repository
public interface DojoRpo extends CrudRepository<DojoMdl, Long>{
	List<DojoMdl> findAll(); 

	// end repo
}
