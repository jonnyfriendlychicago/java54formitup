package com.jonfriend.java54formitup.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.java54formitup.models.UserMdl;

@Repository
public interface UserRpo extends CrudRepository<UserMdl, Long> {
    
    Optional<UserMdl> findByEmail(String email);
// end of rpo   
}