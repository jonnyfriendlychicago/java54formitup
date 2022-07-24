package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.DojoMdl;
import com.jonfriend.java54formitup.repositories.DojoRpo;

@Service
public class DojoSrv {
	
	// adding the dojo repository as a dependency
	private final DojoRpo dojoRpo; 
	
	public DojoSrv(DojoRpo dojoRpo) {
		this.dojoRpo = dojoRpo;
	}
	
	// returns all the dojo
	public List<DojoMdl> returnAll() {
		return dojoRpo.findAll(); 
	}
	
	// creates one dojo
	public DojoMdl createNew(DojoMdl x) {
		return dojoRpo.save(x); 
	}
	
	// updates one dojo
    public DojoMdl update(DojoMdl x) {
        return dojoRpo.save(x);
    }
	
	// returns one dojo by id
	public DojoMdl findById(Long id) {
		Optional<DojoMdl> optionalDojo = dojoRpo.findById(id); 
		if(optionalDojo.isPresent()) {
			return optionalDojo.get(); 
		} else {
			return null; 
		}
	}
	
	// delete dojo by id
	public void  delete(Long id) {
		Optional<DojoMdl> deleteThisDojoId = dojoRpo.findById(id); 
		if(deleteThisDojoId.isPresent()) {
			 dojoRpo.deleteById(id); 
		} else {
			System.out.println("WTF happened here, Jon... "); 
		}
		}
// end srv

	
}
