package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.TwintwoMdl;
import com.jonfriend.java54formitup.models.TwinoneMdl;
import com.jonfriend.java54formitup.repositories.TwinoneRpo;

@Service
public class TwinoneSrv {
	
	// adding the twinone repository as a dependency
	private final TwinoneRpo twinoneRpo;
	
	public TwinoneSrv(TwinoneRpo twinoneRpo) {this.twinoneRpo = twinoneRpo;}
	
	// creates one twinone 
//	public TwinoneMdl addTwinone(TwinoneMdl x) {
	public TwinoneMdl create(TwinoneMdl x) {
		return twinoneRpo.save(x);
	}

	// updates one twinone 
	public TwinoneMdl update(TwinoneMdl x) {
		return twinoneRpo.save(x);
	}
	
	// delete twinone by id >> rename as delete
//	public void deleteTwinone(TwinoneMdl x) {
	public void delete(TwinoneMdl x) {
		twinoneRpo.delete(x);
	}
	
	// returns one twinone by id >> no need rename
	public TwinoneMdl findById(Long id) {
		Optional<TwinoneMdl> optionalTwinone = twinoneRpo.findById(id);
		if(optionalTwinone.isPresent()) {
			return optionalTwinone.get();
		}else {
			return null;
		}
	}
	
	// returns all twinone >> RENAME AS returnAll
	public List<TwinoneMdl> returnAll(){
		return twinoneRpo.findAll();
	}
	
	// get all joined twinone 
	public List<TwinoneMdl> getAssignedTwintwos(TwintwoMdl x){
		return twinoneRpo.findAllByTwintwoMdl(x);
	}
	
	// get all un-joined twinone 
	public List<TwinoneMdl> getUnassignedTwintwos(TwintwoMdl x){
		return twinoneRpo.findByTwintwoMdlNotContains(x);
	}
	
	// this is for removing a twinone-twintwo join record/entry
	
	public void removeTwinoneTwintwoJoin(TwintwoMdl c, TwinoneMdl p ) {
		List<TwintwoMdl> twintwoList = p.getTwintwoMdl(); 
		twintwoList.remove(c); 
		this.twinoneRpo.save(p); 
	}
	
	
}