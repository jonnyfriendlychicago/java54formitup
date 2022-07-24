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

import com.jonfriend.java54formitup.models.PersonMdl;
import com.jonfriend.java54formitup.services.PersonSrv;

@Controller
public class PersonCtl {
	
	@Autowired
	PersonSrv personSrv; 

// ******************************************************************************************
// *** person methods below *** (personPlus methods below that) 
// ******************************************************************************************
	
	// display list of all records
	@RequestMapping("/person")
	public String displayAll(Model model) {
		List<PersonMdl> listy = personSrv.returnAll();
		model.addAttribute("personList", listy); 
		return "person/list.jsp"; 
		// list
	}
	
	// view one record
	@GetMapping("/person/{personId}")
	public String displayOne(Model model, @PathVariable("personId") Long personId ) {
		PersonMdl intVar = personSrv.findById(personId);
		model.addAttribute("person", intVar);
		return "person/record.jsp";
		// record
	}
	
	// new record: initiate it!
	@RequestMapping("/person/new")
	public String initiateNewOne( @ModelAttribute("person") PersonMdl personMdl ) {
		return "person/new.jsp";
		// new
	}
	
	// new record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/person/new") 
	public String processNewOne(
		@Valid 
		@ModelAttribute("person") PersonMdl personMdl 
		, BindingResult result
	) {
		
		if (result.hasErrors()) {
            return "person/new.jsp";
        } else {
        	personSrv.createNew(personMdl);
            return "redirect:/person";
        }
	}
	
	// edit record: initiate it!
	@GetMapping("/person/{personId}/edit")
	public String editOne(@PathVariable("personId") Long personId, Model model) {
		PersonMdl intVar = personSrv.findById(personId); 
		model.addAttribute("person", intVar);  
		return "person/edit.jsp";
		// edit
	}
	
	// edit record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/person/{personId}/edit")
	public String update(
			@Valid 
			@ModelAttribute("person") PersonMdl personMdl 
			, BindingResult result) {
		if (result.hasErrors()) {
			return "person/edit.jsp";
		} else {
			personSrv.update(personMdl);
			return "redirect:/person";
		}
	}
	
    @DeleteMapping("/person/{personId}")
    public String deleteOne(@PathVariable("personId") Long personId) {
    	personSrv.delete(personId);
        return "redirect:/person";
    }
    
// ******************************************************************************************
// *** personPlus methods below ***
//******************************************************************************************
	
    // display list of all records, with create form
	@RequestMapping("/personplus")
	public String personplus(@ModelAttribute("person") PersonMdl personMdl , Model model) {
		List<PersonMdl> intVar = personSrv.returnAll();
		model.addAttribute("personList", intVar); 
		return "personplus/list.jsp"; 
		// list
	}
	
	// display list, then process the new 
	@PostMapping("/personplus") 
	public String personplus(
		@Valid 
		@ModelAttribute("person") PersonMdl personMdl 
		, BindingResult result
		, Model model
		
	) {
		if (result.hasErrors()) { 
            List<PersonMdl> intVar = personSrv.returnAll();
    		model.addAttribute("personList", intVar);
//    		return "personlistcreate.jsp";
    		return "personplus/list.jsp";
    		
        } else {
        	personSrv.createNew(personMdl);
            return "redirect:/personplus";
        }
	}
	
	// display list while editting a record
	// edit record: initiate it!
	@RequestMapping("/personplus/{personId}/edit")
	public String displayAllEditOne(@PathVariable("personId") Long personId, Model model) {
		
		List<PersonMdl> intVar2 = personSrv.returnAll();
		model.addAttribute("personList", intVar2); 
		
		PersonMdl intVar = personSrv.findById(personId); 
		model.addAttribute("person", intVar);  
		return "personplus/edit.jsp";
	}
	// edit
	
	// edit record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/personplus/{personId}/edit")
	public String displayAllEditOne(
			@Valid 
			@ModelAttribute("person") PersonMdl personMdl 
			, BindingResult result
			, Model model) {
		if (result.hasErrors()) {
			List<PersonMdl> intVar2 = personSrv.returnAll();
			model.addAttribute("personList", intVar2); 
//			return "personlistedit.jsp";
			return "personplus/edit.jsp";
		} else {
			personSrv.update(personMdl);
			return "redirect:/personplus";
		}
	}
	
    @DeleteMapping("/personplus/{personId}")
    public String displayAllDeleteOne(@PathVariable("personId") Long personId) {
    	personSrv.delete(personId);
        return "redirect:/personplus";
    }
    
 // view one record
 	@GetMapping("/personplus/{personId}")
 	public String fromDisplayAllJustDisplayOne(Model model, @PathVariable("personId") Long personId ) {
 		PersonMdl intVar = personSrv.findById(personId);
 		model.addAttribute("person", intVar);
 		return "personplus/record.jsp";
 		// record
 	}

	// end of ctl
}
