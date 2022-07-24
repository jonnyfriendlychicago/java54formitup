//find/replace instances of 'java22displaydate' with trueName of project
package com.jonfriend.java54formitup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

//import org.springframework.web.bind.annotation.PathVariable;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.time.LocalDateTime; 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.text.SimpleDateFormat;

import com.jonfriend.java54formitup.models.CategoryMdl;
import com.jonfriend.java54formitup.models.LoginUserMdl;
import com.jonfriend.java54formitup.models.ProductMdl;
import com.jonfriend.java54formitup.models.TwinoneMdl;
import com.jonfriend.java54formitup.models.TwintwoMdl;
import com.jonfriend.java54formitup.models.UserMdl;
import com.jonfriend.java54formitup.services.CategorySrv;
import com.jonfriend.java54formitup.services.ProductSrv;
import com.jonfriend.java54formitup.services.TwinoneSrv;
import com.jonfriend.java54formitup.services.TwintwoSrv;
import com.jonfriend.java54formitup.services.UserSrv;

@Controller
public class HomeController {
	
	@Autowired
	private UserSrv userSrv;
	
//	JRF-FRI: begin cut to HomeController
	@Autowired
	private ProductSrv productSrv;
	
	@Autowired
	private CategorySrv categorySrv;
	
	@Autowired
	private TwinoneSrv twinoneSrv;
	
	@Autowired
	private TwintwoSrv twintwoSrv;

//	JRF-FRI: end cut to HomeController
	
	@GetMapping("/")
	public String index(
			Model model
			, HttpSession session) {
        
// ********************************************************************
// AUTHENTICATION CONTROLS
// ********************************************************************
		
		// *** REDIRECT AUTH USERS TO /home METHOD -- DON'T EXPOSE REG/LOGIN index page TO ALREADY AUTH'ED USERS ***
//		if(session.getAttribute("userId") != null) {return "redirect:/home";}

		// login/reg form items: putting a new empty model for reg (and one for login too) on the index page, so user can shove data onto using the form. 
        model.addAttribute("newUser", new UserMdl());
        model.addAttribute("newLogin", new LoginUserMdl());
        
//      Begin: counter stuff
        Integer currentCount = 0; 
        // if session count hasn't started yet, i.e. first visit, set it to '1'
        if (session.getAttribute("count") == null) {
        	session.setAttribute("count", 1);
        // if session already running, get the current count and add '1' to it.
        } else { 
        	currentCount = (Integer) session.getAttribute("count");
        	currentCount ++; 
        	session.setAttribute("count", currentCount); 
        }
        model.addAttribute("countToShow", currentCount);
//        End: counter stuff
        
		return "index.jsp"; 
	}

    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") UserMdl newUser
    		, BindingResult result
    		, Model model
    		, HttpSession session
    		) {
        
    	UserMdl user = userSrv.register(newUser, result);
    	
    	// TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Below sends in the empty LoginUser before re-rendering the reg/login page; the reg model will maintain the incoming values to this method
            model.addAttribute("newLogin", new LoginUserMdl());
            return "index.jsp";
        }
        
        // No errors?  Store their ID from the DB in session, log in.
        session.setAttribute("userId", user.getId());
   	 
	    return "redirect:/home";
        // Above is our default dashboard location, which can be embraced if/when the app shall be expanded to have a "dashboard"/"home page".
	    // This "home/dashboard" page can display content from numerous sub apps, as well as links to those apps.  
	    // This general landing page, in other words, helps the app be readily scalable.  
	    // At present, the /home route that we are directing to above will itself redirect to the presently-targeted app, 
	    // thereby side-stepping the multi-faceted dashboard/home page.
	    // When we are ready to have a mult-faceted webapp, just change the redirect on the /home method to instead render the home.jsp page. 
    }
    
    @PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUserMdl newLogin
    		, BindingResult result
    		, Model model
    		, HttpSession session) {
    	
    	UserMdl user = userSrv.login(newLogin, result);
    	
        if(result.hasErrors() || user==null ) {
            model.addAttribute("newUser", new UserMdl());
            return "index.jsp";
        }
    
        session.setAttribute("userId", user.getId());
   	 
	    return "redirect:/home";
        // see comment in /register method regarding above redirect. Same thing applies.   
    }
    
    @GetMapping("/home")
	public String home(
			Model model
			, HttpSession session) {
	 
		// Redirect all non-auth users to /logout method.
		if(session.getAttribute("userId") == null) {return "redirect:/logout";}
		
		// create userId object from session.userid value.  We then use this object to display on page, and use for various validations. 
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userSrv.findById(userId));
		
//		JRF-FRI: begin cut to HomeController

		List<ProductMdl> intVar1 = productSrv.allProducts();
		model.addAttribute("productList", intVar1);

		List<CategoryMdl> intVar2 = categorySrv.allCategories();
		model.addAttribute("categoryList", intVar2);
		
//		JRF-FRI: end cut to HomeController 
		
		List<TwinoneMdl> intVar3 = twinoneSrv.returnAll();
		model.addAttribute("twinoneList", intVar3);

		List<TwintwoMdl> intVar4 = twintwoSrv.returnAll();
		model.addAttribute("twintwoList", intVar4);
		
	    return "home.jsp";
		// above is our dashboard; below is whatever "home app" you like to be skipping to.
//	    return "redirect:/store";
	    
	}
    
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
	    return "redirect:/";
	}

 // ********************************************************************
 // MISCELLANEOUS CONTROLS
 // ********************************************************************
    
	@RequestMapping("/reset-counter/")
	public String resetCounter(HttpSession session, Model model, HttpServletRequest request) {
		
		session.setAttribute("count", 0);
		return "redirect:/";
	}
	
	@RequestMapping("/date")
	public String dateRoute(Model model) {
		
		LocalDateTime myDateObj = LocalDateTime.now(); // Create a date object
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
		String formattedDate = myDateObj.format(myFormatObj);
		model.addAttribute("displayDate", formattedDate);
		
		SimpleDateFormat dayName = new SimpleDateFormat("EEEE");
		SimpleDateFormat dayOfMonth = new SimpleDateFormat("dd");
		SimpleDateFormat spelledOutMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat yearFourNums = new SimpleDateFormat("Y");
		
		Date dateObj = new Date(); 
		
		String dayNameString = dayName.format(dateObj); 
		String dayOfMonthString = dayOfMonth.format(dateObj); 
		String spelledOutMonthString = spelledOutMonth.format(dateObj); 
		String yearFourNumsString = yearFourNums.format(dateObj); 
		
		String comprehensiveDateString = dayNameString + ", the " + dayOfMonthString + " of "  + spelledOutMonthString + ", " + yearFourNumsString + " "; 
		
		model.addAttribute("displayDate2", comprehensiveDateString);
		
		return "date.jsp"; 
	}

	@RequestMapping("/time")
	public String timeRoute(Model model) {
		
		SimpleDateFormat easyTime = new SimpleDateFormat("h:mm a");
		
		Date dateObj = new Date(); 
		
		String easyTimeString = easyTime.format(dateObj); 
		
//		String comprehensiveDateString = dayNameString + ", the " + dayOfMonthString + " of "  + spelledOutMonthString + ", " + yearFourNumsString + " "; 
		
		model.addAttribute("displayTime", easyTimeString);
		
		return "time.jsp"; 
	}

// end of methods
}
