package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.NinjaMdl;
import com.jonfriend.java54formitup.repositories.NinjaRpo;

@Service
public class NinjaSrv {
	
	// adding the ninja repository as a dependency
	private final NinjaRpo ninjaRpo; 
	
	public NinjaSrv(NinjaRpo ninjaRpo) {
		this.ninjaRpo = ninjaRpo;
	}
	
	// returns all the ninja
	public List<NinjaMdl> returnAll() {
		return ninjaRpo.findAll(); 
	}
	
	// creates one ninja
	public NinjaMdl createNew(NinjaMdl x) {
		return ninjaRpo.save(x); 
	}
	
	// updates one ninja
    public NinjaMdl update(NinjaMdl x) {
        return ninjaRpo.save(x);
    }
	
	// returns one ninja by id
	public NinjaMdl findById(Long id) {
		Optional<NinjaMdl> optionalNinja = ninjaRpo.findById(id); 
		if(optionalNinja.isPresent()) {
			return optionalNinja.get(); 
		} else {
			return null; 
		}
	}
	
	// delete ninja by id
	public void  delete(Long id) {
			Optional<NinjaMdl> deleteThisNinjaId = ninjaRpo.findById(id); 
			if(deleteThisNinjaId.isPresent()) {
				 ninjaRpo.deleteById(id); 
			} else {
				System.out.println("WTF happened here, Jon... "); 
			}
		}

	
	
// end srv	
}
