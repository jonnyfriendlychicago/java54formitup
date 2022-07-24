package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.ProductMdl;
import com.jonfriend.java54formitup.models.PublicationMdl;
import com.jonfriend.java54formitup.repositories.PublicationRpo;

@Service
public class PublicationSrv {
	
	// adding the publication repository as a dependency
	private final PublicationRpo publicationRpo; 
	
	public PublicationSrv(PublicationRpo publicationRpo) {
		this.publicationRpo = publicationRpo;
	}
	
	// returns all the publication
	public List<PublicationMdl> returnAll() {
		return publicationRpo.findAll(); 
	}
	
	// creates one publication
	public PublicationMdl createNew(PublicationMdl x) {
		return publicationRpo.save(x); 
	}
	
	// updates one publication
    public PublicationMdl update(PublicationMdl x) {
        return publicationRpo.save(x);
    }
	
	// returns one publication by id
	public PublicationMdl findById(Long id) {
		Optional<PublicationMdl> optionalPublication = publicationRpo.findById(id); 
		if(optionalPublication.isPresent()) {
			return optionalPublication.get(); 
		} else {
			return null; 
		}
	}
	
	// delete publication by id
	// this delete method enables more checking and error msg'ing; 
	public void  delete(Long id) {
			Optional<PublicationMdl> deleteThisPublicationId = publicationRpo.findById(id); 
			if(deleteThisPublicationId.isPresent()) {
				 publicationRpo.deleteById(id); 
			} else {
				System.out.println("WTF happened here, Jon... "); 
			}
		}
	
	// JRF: this method just deletes the record, but can't do anything else; just redirect. 
	public void deleteNoThought(PublicationMdl x) {
		publicationRpo.delete(x);
		}

	
	
// end srv	
}
