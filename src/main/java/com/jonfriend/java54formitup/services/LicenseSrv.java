package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.LicenseMdl;
import com.jonfriend.java54formitup.repositories.LicenseRpo;

@Service
public class LicenseSrv {
	
	// adding the license repository as a dependency
	private final LicenseRpo licenseRpo; 
	
	public LicenseSrv(LicenseRpo licenseRpo) {
		this.licenseRpo = licenseRpo;
	}
	
	// returns all the license
	public List<LicenseMdl> returnAll() {
		return licenseRpo.findAll(); 
	}
	
	// creates one license
	public LicenseMdl createNew(LicenseMdl x) {
		return licenseRpo.save(x); 
	}
	
	// updates one license
    public LicenseMdl update(LicenseMdl x) {
        return licenseRpo.save(x);
    }
	
	// returns one license by id
	public LicenseMdl findById(Long id) {
		Optional<LicenseMdl> optionalLicense = licenseRpo.findById(id); 
		if(optionalLicense.isPresent()) {
			return optionalLicense.get(); 
		} else {
			return null; 
		}
	}
	
	// delete license by id
	public void  delete(Long id) {
			Optional<LicenseMdl> deleteThisLicenseId = licenseRpo.findById(id); 
			if(deleteThisLicenseId.isPresent()) {
				 licenseRpo.deleteById(id); 
			} else {
				System.out.println("WTF happened here, Jon... "); 
			}
		}

	
	
// end srv	
}
