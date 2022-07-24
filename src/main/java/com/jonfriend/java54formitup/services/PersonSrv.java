package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.PersonMdl;
import com.jonfriend.java54formitup.repositories.PersonRpo;

@Service
public class PersonSrv {
	
	// adding the person repository as a dependency
	private final PersonRpo personRpo; 
	
	public PersonSrv(PersonRpo personRpo) {
		this.personRpo = personRpo;
	}
	
	// returns all the person
	public List<PersonMdl> returnAll() {
		return personRpo.findAll(); 
	}
	
	// creates one person
	public PersonMdl createNew(PersonMdl x) {
		return personRpo.save(x); 
	}
	
	// updates one person
    public PersonMdl update(PersonMdl x) {
        return personRpo.save(x);
    }
	
	// returns one person by id
	public PersonMdl findById(Long id) {
		Optional<PersonMdl> optionalPerson = personRpo.findById(id); 
		if(optionalPerson.isPresent()) {
			return optionalPerson.get(); 
		} else {
			return null; 
		}
	}
	
	// delete person by id
	public void  delete(Long id) {
		Optional<PersonMdl> deleteThisPersonId = personRpo.findById(id); 
		if(deleteThisPersonId.isPresent()) {
			 personRpo.deleteById(id); 
		} else {
			System.out.println("WTF happened here, Jon... "); 
		}
		}
// end srv

	
}
