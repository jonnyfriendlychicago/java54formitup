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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonfriend.java54formitup.models.ExpenseMdl;
import com.jonfriend.java54formitup.services.ExpenseSrv;

@Controller
public class ExpenseCtl {

	@Autowired
	ExpenseSrv expenseSrv; 
//	JRF what does autowired mean/do?  this a func I could be exploiting further?
	
	@RequestMapping("/expenses")
	public String expenseList(Model model) {
		List<ExpenseMdl> expenseListy = expenseSrv.allExpense();
		model.addAttribute("expenseListy", expenseListy); 
		return "expenselist.jsp"; 
	}

	@RequestMapping("/expenses/{expenseId}") 
	public String expenseView(Model model, @PathVariable("expenseId") Long expenseId) {
		ExpenseMdl expenseMdl = expenseSrv.findExpense(expenseId); 
		model.addAttribute("expense", expenseMdl);  
		return "expenseprofile.jsp"; 
	}
	
	@RequestMapping("/expenses/new")
	public String createExpense( @ModelAttribute("expense") ExpenseMdl expenseMdl ) {
		return "expensecreatenew.jsp";
	}
	
//	JRF add "on same page" attempt below
	
	@RequestMapping("/expensesAndCreate")
	public String expensesAndCreate(@ModelAttribute("expense") ExpenseMdl expenseMdl, Model model) {
		List<ExpenseMdl> expenseListy = expenseSrv.allExpense();
		model.addAttribute("expenseListy", expenseListy); 
		return "expenselistandcreate.jsp"; 
	}

	@PostMapping("/expensesAndCreate") 
//	JRF: above can have the same name as the "list" page, b/c they have diff mapping methods; this resolves the goofy naming issue I had
	public String expensesAndCreate(
		@Valid 
		@ModelAttribute("expense") ExpenseMdl expenseMdl
		, BindingResult result
		, Model model
		
	) {
		if (result.hasErrors()) {
//          return "expensecreatenew.jsp"; 
//        	JRF above goes to list alone; 
//			JRF: below goes to combo, and it works... but it does not show the good records in the table
//          return "expenselistandcreate.jsp";
//          JRF below no good: it renders the page w/o user entries and w/o error msgs
//			return "redirect:/expensesAndCreate";
            
//			JRF: below seems to be the way to go: incorporate good parts from above into error route 
            List<ExpenseMdl> expenseListy = expenseSrv.allExpense();
    		model.addAttribute("expenseListy", expenseListy);
    		return "expenselistandcreate.jsp";
    		
        } else {
        	expenseSrv.createExpense(expenseMdl);
//            return "redirect:/expenses";
//        	JRF above goes to list alone; below goes to combo
            return "redirect:/expensesAndCreate";
        }
	}

//	JRF: update meth
	
    @GetMapping("/expenses/{expenseId}/edit")
    public String editExpense(@PathVariable("expenseId") Long expenseId, Model model) {
    	ExpenseMdl expenseMdl = expenseSrv.findExpense(expenseId); 
		model.addAttribute("expense", expenseMdl);  
        return "expenseprofileedit.jsp";
    }


    @PutMapping("/expenses/{expenseId}/edit")
    public String updateExpense(@Valid @ModelAttribute("expense") ExpenseMdl expenseMdl, BindingResult result) {
        if (result.hasErrors()) {
            return "expenseprofileedit.jsp";
        } else {
        	expenseSrv.updateExpense(expenseMdl);
            return "redirect:/expensesAndCreate";
        }
    }
    
    @DeleteMapping("/expenses/{expenseId}")
    public String delete(@PathVariable("expenseId") Long expenseId) {
    	expenseSrv.delete(expenseId);
        return "redirect:/expensesAndCreate";
    }

	
	
	
	
	
	// end ctl
}
