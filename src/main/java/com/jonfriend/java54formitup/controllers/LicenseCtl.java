package com.jonfriend.java54formitup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonfriend.java54formitup.models.LicenseMdl;
import com.jonfriend.java54formitup.models.PersonMdl;
import com.jonfriend.java54formitup.services.LicenseSrv;
import com.jonfriend.java54formitup.services.PersonSrv;

@Controller
public class LicenseCtl {
	
	@Autowired
	private LicenseSrv licenseSrv; 
	
	// JRF: below adding the AW for the pers serv
	
	@Autowired
	private PersonSrv personSrvIntVar; 

// ******************************************************************************************
// *** license methods below *** (licensePlus methods below that) 
// ******************************************************************************************
	
//	// display list of all records
//	@RequestMapping("/license")
//	public String displayAll(Model model) {
//		List<LicenseMdl> listy = licenseSrv.returnAll();
//		model.addAttribute("licenseList", listy); 
//		return "license/list.jsp"; 
//		// list
//	}
//	
//	// view one record
//	@GetMapping("/license/{licenseId}")
//	public String displayOne(Model model, @PathVariable("licenseId") Long licenseId ) {
//		LicenseMdl intVar = licenseSrv.findById(licenseId);
//		model.addAttribute("license", intVar);
//		return "license/record.jsp";
//		// record
//	}
//	
//	// new record: initiate it!
//	@RequestMapping("/license/new")
//	public String initiateNewOne( @ModelAttribute("license") LicenseMdl licenseMdl ) {
//		return "license/new.jsp";
//		// new
//	}
//	
//	// new record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/license/new") 
//	public String processNewOne(
//		@Valid 
//		@ModelAttribute("license") LicenseMdl licenseMdl 
//		, BindingResult result
//	) {
//		
//		if (result.hasErrors()) {
//            return "license/new.jsp";
//        } else {
//        	licenseSrv.createNew(licenseMdl);
//            return "redirect:/license";
//        }
//	}
//	
//	// edit record: initiate it!
//	@GetMapping("/license/{licenseId}/edit")
//	public String editOne(@PathVariable("licenseId") Long licenseId, Model model) {
//		LicenseMdl intVar = licenseSrv.findById(licenseId); 
//		model.addAttribute("license", intVar);  
//		return "license/edit.jsp";
//		// edit
//	}
//	
//	// edit record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/license/{licenseId}/edit")
//	public String update(
//			@Valid 
//			@ModelAttribute("license") LicenseMdl licenseMdl 
//			, BindingResult result) {
//		if (result.hasErrors()) {
//			return "license/edit.jsp";
//		} else {
//			licenseSrv.update(licenseMdl);
//			return "redirect:/license";
//		}
//	}
//	
//    @DeleteMapping("/license/{licenseId}")
//    public String deleteOne(@PathVariable("licenseId") Long licenseId) {
//    	licenseSrv.delete(licenseId);
//        return "redirect:/license";
//    }
    
// ******************************************************************************************
// *** licensePlus methods below ***
//******************************************************************************************
	
    // display list of all records, with create form
	@RequestMapping("/licenseplus")
	public String licenseplus(@ModelAttribute("license") LicenseMdl licenseMdl , Model model) {
		List<LicenseMdl> intVar = licenseSrv.returnAll();
		model.addAttribute("licenseList", intVar); 
		// below added in prayer that drop-down now works
		List<PersonMdl> intVar2 = personSrvIntVar.returnAll();
		model.addAttribute("personList", intVar2); 
		return "licenseplus/list.jsp"; 
		// list
	}
	
	// display list, then process the new 
	@PostMapping("/licenseplus") 
	public String licenseplus(
		@Valid 
		@ModelAttribute("license") LicenseMdl licenseMdl 
		, BindingResult result
		, Model model
		
	) {
		if (result.hasErrors()) { 
            List<LicenseMdl> intVar = licenseSrv.returnAll();
    		model.addAttribute("licenseList", intVar);
//    		return "licenselistcreate.jsp";
    		return "licenseplus/list.jsp";
    		
        } else {
        	licenseSrv.createNew(licenseMdl);
            return "redirect:/licenseplus";
        }
	}
	
	// display list while editting a record
	// edit record: initiate it!
	@RequestMapping("/licenseplus/{licenseId}/edit")
	public String displayAllEditOne(@PathVariable("licenseId") Long licenseId, Model model) {
		
		List<LicenseMdl> intVar2 = licenseSrv.returnAll();
		model.addAttribute("licenseList", intVar2); 
		
		LicenseMdl intVar = licenseSrv.findById(licenseId); 
		model.addAttribute("license", intVar);  
		return "licenseplus/edit.jsp";
	}
	// edit
	
	// edit record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/licenseplus/{licenseId}/edit")
	public String displayAllEditOne(
			@Valid 
			@ModelAttribute("license") LicenseMdl licenseMdl 
			, BindingResult result
			, Model model) {
		if (result.hasErrors()) {
			List<LicenseMdl> intVar2 = licenseSrv.returnAll();
			model.addAttribute("licenseList", intVar2); 
//			return "licenselistedit.jsp";
			return "licenseplus/edit.jsp";
		} else {
			licenseSrv.update(licenseMdl);
			return "redirect:/licenseplus";
		}
	}
	
    @DeleteMapping("/licenseplus/{licenseId}")
    public String displayAllDeleteOne(@PathVariable("licenseId") Long licenseId) {
    	licenseSrv.delete(licenseId);
        return "redirect:/licenseplus";
    }
    
 // view one record
 	@GetMapping("/licenseplus/{licenseId}")
 	public String fromDisplayAllJustDisplayOne(Model model, @PathVariable("licenseId") Long licenseId ) {
 		LicenseMdl intVar = licenseSrv.findById(licenseId);
 		model.addAttribute("license", intVar);
 		return "licenseplus/record.jsp";
 		// record
 	}

	// end of ctl
}
