package com.jonfriend.java54formitup.controllers;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jonfriend.java54formitup.models.TwintwoMdl;
import com.jonfriend.java54formitup.models.TwinoneMdl;
import com.jonfriend.java54formitup.services.TwintwoSrv;
import com.jonfriend.java54formitup.services.UserSrv;
import com.jonfriend.java54formitup.services.TwinoneSrv;
//import com.jonfriend.java54formitup.services.UserSrv;

@Controller
public class TwintwoCtl {

	@Autowired
	private TwinoneSrv twinoneSrv;
	
	@Autowired
	private TwintwoSrv twintwoSrv;
	
	@Autowired
	private UserSrv userSrv;
//	@Autowired
//	private UserSrv userSrv;
	
	// display create-new page
	@GetMapping("/twintwo/new")
	public String newTwintwo(
			@ModelAttribute("twintwo") TwintwoMdl twintwoMdl
			, Model model
			, HttpSession session
			) {
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		return "twintwo/create.jsp";
	}
	
	
	// process the create-new 
	@PostMapping("/twintwo/new")
	public String addNewTwintwo(
			@Valid @ModelAttribute("twintwo") TwintwoMdl twintwoMdl
			, BindingResult result
			, Model model
			, HttpSession session
			) {
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		if(result.hasErrors()) {
			return "twintwo/create.jsp";
		} else {
			twintwoSrv.create(twintwoMdl);
			return "redirect:/home";
		}	
	}
	
	// view record
	@GetMapping("/twintwo/{id}")
	public String showTwintwo(
			@PathVariable("id") Long id
			, Model model
			, HttpSession session
			) {
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		TwintwoMdl twintwo = twintwoSrv.findById(id);
		
		model.addAttribute("twintwo", twintwoSrv.findById(id));
		model.addAttribute("assignedTwinones", twinoneSrv.getAssignedTwintwos(twintwo));
		model.addAttribute("unassignedTwinones", twinoneSrv.getUnassignedTwintwos(twintwo));
		
		return "/twintwo/record.jsp";
	}
	
	
	// display edit page
	@GetMapping("/twintwo/{id}/edit")
	public String editTwintwo(
			@PathVariable("id") Long twintwoId
			, Model model
			, HttpSession session
			) {
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}

		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		// pre-populates the values in the management interface
		TwintwoMdl intVar = twintwoSrv.findById(twintwoId);
		
		model.addAttribute("twintwo", intVar);
		model.addAttribute("assignedTwinones", twinoneSrv.getAssignedTwintwos(intVar));
		model.addAttribute("unassignedTwinones", twinoneSrv.getUnassignedTwintwos(intVar));
		
		// records in 'manage-one' interface dropdown
//		List<DojoMdl> intVar3 = dojoSrvIntVar.returnAll();
//		model.addAttribute("dojoList", intVar3); 
		
		return "twintwo/edit.jsp";
	}
	
	// process edits
	@PostMapping("/twintwo/{id}/edit")
	public String PostTheEditTwintwo(
			@Valid 
			@ModelAttribute("twintwo") TwintwoMdl twintwoMdl 
			, BindingResult result
			, Model model
			, @PathVariable("id") Long twintwoId 
			, HttpSession session
			, RedirectAttributes redirectAttributes
			) {
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// trying here to stop someone from forcing this method when not creator; was working, now no idea.... sigh 7/19 2pm
//		 Long userId = (Long) session.getAttribute("userId"); 
//		 PublicationMdl intVar = twintwoSrv.findById(twintwoId);
		
		// System.out.println("in the postMapping for edit..."); 
		// System.out.println("intVar.getUserMdl().getId(): " + intVar.getUserMdl().getId()); 
		// System.out.println("userId: " + userId); 
		
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can edit it.");
//			return "redirect:/publication";
//		}
		TwintwoMdl intVar = twintwoSrv.findById(twintwoId);
		
		if (result.hasErrors()) { 
			
            Long userId = (Long) session.getAttribute("userId");
            model.addAttribute("user", userSrv.findById(userId));            
//            model.addAttribute("twintwo", intVar);
            model.addAttribute("assignedCategories", twinoneSrv.getAssignedTwintwos(intVar));
            model.addAttribute("unassignedCategories", twinoneSrv.getUnassignedTwintwos(intVar));

			return "twintwo/edit.jsp";
		} else {
			
			twintwoMdl.setTwinoneMdl(twinoneSrv.getAssignedTwintwos(intVar)); 
			twintwoSrv.update(twintwoMdl);
			
			return "redirect:/twintwo/" + twintwoId;
		}
	}
	
	// legacy, before whole edit added. 
//	@PostMapping("/twintwo/{id}")
//	
//	public String editTwintwo(
//			@PathVariable("id") Long id
//			, @RequestParam(value="twinoneId") Long twinoneId
//			, Model model
//			) {
//		
//		TwintwoMdl twintwo = twintwoSrv.findById(id);
//		TwinoneMdl twinone = twinoneSrv.findById(twinoneId);
//		
//		twintwo.getTwinoneMdl().add(twinone);
//		twintwoSrv.updateTwintwo(twintwo);
//		model.addAttribute("assignedTwinones", twinoneSrv.getAssignedCategories(twintwo));
//		model.addAttribute("unassignedTwinones", twinoneSrv.getUnassignedCategories(twintwo));
//		return "redirect:/twintwo/" + id;
//		
//	}
	
	// process new joins for that one twintwo
	@PostMapping("/twintwo/{id}/editTwinoneJoins")
	public String postTwintwoTwinoneJoin(
//			@PathVariable("id") Long id
			@PathVariable("id") Long twintwoId
			, @RequestParam(value="twinoneId") Long twinoneId // requestParam is only used with regular HTML form 
			,  Model model
			, HttpSession session
			) {
		
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// We get the userId from our session (we need to cast the result to a Long as the 'session.getAttribute("userId")' returns an object
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
		TwintwoMdl twintwo = twintwoSrv.findById(twintwoId);
		TwinoneMdl twinone = twinoneSrv.findById(twinoneId);
		
		twintwo.getTwinoneMdl().add(twinone);
		
		twintwoSrv.update(twintwo);
		
		// need these two below so that the returned page has this dropdown/table info populated.
		model.addAttribute("assignedCategories", twinoneSrv.getAssignedTwintwos(twintwo));
		model.addAttribute("unassignedCategories", twinoneSrv.getUnassignedTwintwos(twintwo));
//		return "redirect:/twintwo/" + id;
		return "redirect:/twintwo/" + twintwoId + "/edit";
	}
	
	@DeleteMapping("/removeTwintwoTwinoneJoin")
    public String removeTwintwoTwinoneJoin(
    		@RequestParam(value="twinoneId") Long twinoneId // requestParam is only used with regular HTML form
    		, @RequestParam(value="twintwoId") Long twintwoId // requestParam is only used with regular HTML form
    		// below removed, outmoded design
 //    		, @RequestParam(value="origin") Long originPath // requestParam is only used with regular HTML form
    		, HttpSession session
    		, RedirectAttributes redirectAttributes
    		) {

    	// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		TwintwoMdl twintwoObject = twintwoSrv.findById(twintwoId);
		TwinoneMdl twinoneObject  = twinoneSrv.findById(twinoneId);
		
		twintwoSrv.removeTwintwoTwinoneJoin(twinoneObject, twintwoObject); 
		
		
//		if (originPath == 1) {
//			return "redirect:/twintwo/" + twintwoId + "/edit";
//		} else {
//			return "redirect:/twinone/" + twinoneId;
//		}
		
		// above replaced by below, above design outdated.
		
		return "redirect:/twintwo/" + twintwoId + "/edit";
	}
	
	// delete twintwo
    @DeleteMapping("/twintwo/{id}")
    public String deleteTwintwo(
    		@PathVariable("id") Long twintwoId
    		, HttpSession session
    		, RedirectAttributes redirectAttributes
    		) {
		// If no userId is found in session, redirect to logout.  JRF: put this on basically all methods now, except the login/reg pages
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// trying here to stop someone from forcing this method when not creator
		Long userId = (Long) session.getAttribute("userId"); 
		TwintwoMdl intVar = twintwoSrv.findById(twintwoId);
		
		// below is to prevent non-creator from deleting record
//		if(intVar.getUserMdl().getId() != userId) {
//			redirectAttributes.addFlashAttribute("mgmtPermissionErrorMsg", "Only the creator of a record can delete it.");
//			return "redirect:/publication";
//		}

		twintwoSrv.delete(intVar);
        return "redirect:/home";
    }

// end ctrl
}
