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

import com.jonfriend.java54formitup.models.NinjaMdl;
import com.jonfriend.java54formitup.models.DojoMdl;
import com.jonfriend.java54formitup.services.NinjaSrv;
import com.jonfriend.java54formitup.services.DojoSrv;

@Controller
public class NinjaCtl {
	
	@Autowired
	private NinjaSrv ninjaSrv; 
	
	// JRF: below adding the AW for the pers serv
	
	@Autowired
	private DojoSrv dojoSrvIntVar; 

// ******************************************************************************************
// *** ninja methods below *** (ninjaPlus methods below that) 
// ******************************************************************************************
	
//	// display list of all records
//	@RequestMapping("/ninja")
//	public String displayAll(Model model) {
//		List<NinjaMdl> listy = ninjaSrv.returnAll();
//		model.addAttribute("ninjaList", listy); 
//		return "ninja/list.jsp"; 
//		// list
//	}
//	
//	// view one record
//	@GetMapping("/ninja/{ninjaId}")
//	public String displayOne(Model model, @PathVariable("ninjaId") Long ninjaId ) {
//		NinjaMdl intVar = ninjaSrv.findById(ninjaId);
//		model.addAttribute("ninja", intVar);
//		return "ninja/record.jsp";
//		// record
//	}
//	
//	// new record: initiate it!
//	@RequestMapping("/ninja/new")
//	public String initiateNewOne( @ModelAttribute("ninja") NinjaMdl ninjaMdl ) {
//		return "ninja/new.jsp";
//		// new
//	}
//	
//	// new record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/ninja/new") 
//	public String processNewOne(
//		@Valid 
//		@ModelAttribute("ninja") NinjaMdl ninjaMdl 
//		, BindingResult result
//	) {
//		
//		if (result.hasErrors()) {
//            return "ninja/new.jsp";
//        } else {
//        	ninjaSrv.createNew(ninjaMdl);
//            return "redirect:/ninja";
//        }
//	}
//	
//	// edit record: initiate it!
//	@GetMapping("/ninja/{ninjaId}/edit")
//	public String editOne(@PathVariable("ninjaId") Long ninjaId, Model model) {
//		NinjaMdl intVar = ninjaSrv.findById(ninjaId); 
//		model.addAttribute("ninja", intVar);  
//		return "ninja/edit.jsp";
//		// edit
//	}
//	
//	// edit record: finalize/save it (or get kicked back b/c errors)
//	@PostMapping("/ninja/{ninjaId}/edit")
//	public String update(
//			@Valid 
//			@ModelAttribute("ninja") NinjaMdl ninjaMdl 
//			, BindingResult result) {
//		if (result.hasErrors()) {
//			return "ninja/edit.jsp";
//		} else {
//			ninjaSrv.update(ninjaMdl);
//			return "redirect:/ninja";
//		}
//	}
//	
//    @DeleteMapping("/ninja/{ninjaId}")
//    public String deleteOne(@PathVariable("ninjaId") Long ninjaId) {
//    	ninjaSrv.delete(ninjaId);
//        return "redirect:/ninja";
//    }
    
// ******************************************************************************************
// *** ninjaPlus methods below ***
//******************************************************************************************
	
    // display list of all records, with create form
	@RequestMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") NinjaMdl ninjaMdl , Model model) {
        // records in table
		List<NinjaMdl> intVar1 = ninjaSrv.returnAll();
		model.addAttribute("ninjaList", intVar1); 
		// records in 'add-new' dropdown
		List<DojoMdl> intVar2 = dojoSrvIntVar.returnAll();
		model.addAttribute("dojoList", intVar2); 
		
		String onErrorPath = "nope"; 
		model.addAttribute("onErrorPath", onErrorPath); 
		
		return "ninja/list.jsp"; 
	}
	
	// display list, then process the new 
	@PostMapping("/ninja") 
	public String ninja(
		@Valid 
		@ModelAttribute("ninja") NinjaMdl ninjaMdl 
		, BindingResult result
		, Model model
		
	) {
		if (result.hasErrors()) { 
            // records in table
			List<NinjaMdl> intVar1 = ninjaSrv.returnAll(); 
    		model.addAttribute("ninjaList", intVar1);
    		// records in 'add-new' dropdown
    		List<DojoMdl> intVar2 = dojoSrvIntVar.returnAll();
    		model.addAttribute("dojoList", intVar2); 
    		

    		String onErrorPath = "yep"; 
    		model.addAttribute("onErrorPath", onErrorPath); 
    		
    		return "ninja/list.jsp";
    		
        } else {
//        	boolean onErrorPath = false; 
//    		model.addAttribute("onErrorPath", onErrorPath); 
    		
    		ninjaSrv.createNew(ninjaMdl);
            return "redirect:/ninja";
        }
	}
	
	// display list while editting a record
	// edit record: initiate it!
	@RequestMapping("/ninja/{ninjaId}/edit")
	public String ninjaEdit(@PathVariable("ninjaId") Long ninjaId, Model model) {
		
        // records in table
		List<NinjaMdl> intVar1 = ninjaSrv.returnAll();
		model.addAttribute("ninjaList", intVar1); 
		
		// pre-populates the values in the 'manage-one' interface
		NinjaMdl intVar2 = ninjaSrv.findById(ninjaId); 
		model.addAttribute("ninja", intVar2);  
		
		// records in 'manage-one' interface dropdown
		List<DojoMdl> intVar3 = dojoSrvIntVar.returnAll();
		model.addAttribute("dojoList", intVar3); 
		
		return "ninja/edit.jsp";
		

	}
	
	// edit record: finalize/save it (or get kicked back b/c errors)
	@PostMapping("/ninja/{ninjaId}/edit")
	public String ninjaEdit(
			@Valid 
			@ModelAttribute("ninja") NinjaMdl ninjaMdl 
			, BindingResult result
			, Model model) {
		if (result.hasErrors()) {
			
//			List<NinjaMdl> intVar2 = ninjaSrv.returnAll();
//			model.addAttribute("ninjaList", intVar2); 
			
			List<NinjaMdl> intVar2 = ninjaSrv.returnAll();
			model.addAttribute("ninjaList", intVar2); 
			
//			NinjaMdl intVar = ninjaSrv.findById(ninjaId); 
//			model.addAttribute("ninja", intVar);  
			
			// below added in prayer that drop-down now works
			List<DojoMdl> intVar3 = dojoSrvIntVar.returnAll();
			model.addAttribute("dojoList", intVar3); 
			
			
			return "ninja/edit.jsp";
		} else {
			ninjaSrv.update(ninjaMdl);
			return "redirect:/ninja";
		}
	}
	
    @DeleteMapping("/ninja/{ninjaId}")
    public String displayAllDeleteOne(@PathVariable("ninjaId") Long ninjaId) {
    	ninjaSrv.delete(ninjaId);
        return "redirect:/ninja";
    }
    
 // view one record
 	@GetMapping("/ninja/{ninjaId}")
 	public String fromDisplayAllJustDisplayOne(Model model, @PathVariable("ninjaId") Long ninjaId ) {
 		NinjaMdl intVar = ninjaSrv.findById(ninjaId);
 		model.addAttribute("ninja", intVar);
 		return "ninja/record.jsp";
 	}

	// end of ctl
}
