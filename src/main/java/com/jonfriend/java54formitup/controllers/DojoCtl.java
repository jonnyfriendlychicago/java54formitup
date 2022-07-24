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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonfriend.java54formitup.models.DojoMdl;
import com.jonfriend.java54formitup.services.DojoSrv;

@Controller
public class DojoCtl {
	
	@Autowired
	DojoSrv dojoSrv; 

// ******************************************************************************************
// *** dojo methods below *** (dojoPlus methods below that) 
// ******************************************************************************************
//	
//	// display list of all records
//	@RequestMapping("/dojo")
//	public String displayAll(Model model) {
//		List<DojoMdl> listy = dojoSrv.returnAll();
//		model.addAttribute("dojoList", listy); 
//		return "dojo/list.jsp"; 
//		// list
//	}
//	
//	// view one record
//	@GetMapping("/dojo/{dojoId}")
//	public String displayOne(Model model, @PathVariable("dojoId") Long dojoId ) {
//		DojoMdl intVar = dojoSrv.findById(dojoId);
//		model.addAttribute("dojo", intVar);
//		return "dojo/record.jsp";
//		// record
//	}
//	
//	// new record: initiate it!
//	@RequestMapping("/dojo/new")
//	public String initiateNewOne( @ModelAttribute("dojo") DojoMdl dojoMdl ) {
//		return "dojo/new.jsp";
//		// new
//	}
//	
//	// new record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/dojo/new") 
//	public String processNewOne(
//		@Valid 
//		@ModelAttribute("dojo") DojoMdl dojoMdl 
//		, BindingResult result
//	) {
//		
//		if (result.hasErrors()) {
//            return "dojo/new.jsp";
//        } else {
//        	dojoSrv.createNew(dojoMdl);
//            return "redirect:/dojo";
//        }
//	}
//	
//	// edit record: initiate it!
//	@GetMapping("/dojo/{dojoId}/edit")
//	public String editOne(@PathVariable("dojoId") Long dojoId, Model model) {
//		DojoMdl intVar = dojoSrv.findById(dojoId); 
//		model.addAttribute("dojo", intVar);  
//		return "dojo/edit.jsp";
//		// edit
//	}
//	
//	// edit record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/dojo/{dojoId}/edit")
//	public String update(
//			@Valid 
//			@ModelAttribute("dojo") DojoMdl dojoMdl 
//			, BindingResult result) {
//		if (result.hasErrors()) {
//			return "dojo/edit.jsp";
//		} else {
//			dojoSrv.update(dojoMdl);
//			return "redirect:/dojo";
//		}
//	}
//	
//    @DeleteMapping("/dojo/{dojoId}")
//    public String deleteOne(@PathVariable("dojoId") Long dojoId) {
//    	dojoSrv.delete(dojoId);
//        return "redirect:/dojo";
//    }
    
// ******************************************************************************************
// *** dojoPlus methods below ***
//******************************************************************************************
	
    // display list of all records, with create form
//	@RequestMapping("/dojo") // changed 7-16 330pm
	@GetMapping("/dojo")
	public String dojo(@ModelAttribute("dojo") DojoMdl dojoMdl , Model model) {
		List<DojoMdl> intVar = dojoSrv.returnAll();
		model.addAttribute("dojoList", intVar); 
		
		String onErrorPath = "nope"; 
		model.addAttribute("onErrorPath", onErrorPath); 
		return "dojo/list.jsp"; 
	}
	
	// display list, then process the new 
	@PostMapping("/dojo") 
	public String dojo(
		@Valid 
		@ModelAttribute("dojo") DojoMdl dojoMdl 
		, BindingResult result
		, Model model
		
	) {
		if (result.hasErrors()) { 
            List<DojoMdl> intVar = dojoSrv.returnAll();
    		model.addAttribute("dojoList", intVar);
    		
    		String onErrorPath = "yep"; 
    		model.addAttribute("onErrorPath", onErrorPath); 
    		
    		return "dojo/list.jsp";
    		
        } else {
        	dojoSrv.createNew(dojoMdl);
            return "redirect:/dojo";
        }
	}
	
	// display list while editting a record
	// edit record: initiate it!
	@RequestMapping("/dojo/{dojoId}/edit")
	public String displayAllEditOne(@PathVariable("dojoId") Long dojoId, Model model) {
		
		List<DojoMdl> intVar2 = dojoSrv.returnAll();
		model.addAttribute("dojoList", intVar2); 
		
		DojoMdl intVar = dojoSrv.findById(dojoId); 
		model.addAttribute("dojo", intVar);  
		return "dojo/edit.jsp";
	}
	// edit
	
	// edit record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/dojo/{dojoId}/edit")
	public String displayAllEditOne(
			@Valid 
			@ModelAttribute("dojo") DojoMdl dojoMdl 
			, BindingResult result
			, Model model) {
		if (result.hasErrors()) {
			List<DojoMdl> intVar2 = dojoSrv.returnAll();
			model.addAttribute("dojoList", intVar2); 
			return "dojo/edit.jsp";
		} else {
			dojoSrv.update(dojoMdl);
			return "redirect:/dojo";
		}
	}
	
    @DeleteMapping("/dojo/{dojoId}")
    public String displayAllDeleteOne(@PathVariable("dojoId") Long dojoId, RedirectAttributes redirectAttributes) {
//    	if the count of items in dojo.NinjaMdl list is > 0, error this method and redirect to screeen with a error msg.  flashMsg format? 
//    	else, yeah, whack it
    	
    	
    	DojoMdl intVar = dojoSrv.findById(dojoId);
    	
    	// in below, the get... is used instead of the ninjaList atty b/c it's private, need to use the getter instead
    	if ( intVar.getNinjaList().size() > 0 ) {
    		redirectAttributes.addFlashAttribute("errorThang", "JRF error buddy!");
    		return "redirect:/dojo";
    		
    	} 
		dojoSrv.delete(dojoId);
		return "redirect:/dojo";	
    }
    
 // view one record
 	@GetMapping("/dojo/{dojoId}")
 	public String fromDisplayAllJustDisplayOne(Model model, @PathVariable("dojoId") Long dojoId ) {
 		DojoMdl intVar = dojoSrv.findById(dojoId);
 		model.addAttribute("dojo", intVar);
 		return "dojo/record.jsp";
 		// record
 	}

	// end of ctl
}
