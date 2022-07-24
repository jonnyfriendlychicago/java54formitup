package com.jonfriend.java54formitup.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.jonfriend.java54formitup.models.ExpenseMdl;
import com.jonfriend.java54formitup.repositories.ExpenseRpo;

@Service
public class ExpenseSrv {
	
	// adding the expense repository as a dependency
	private final ExpenseRpo expenseRpo; 
	
	public ExpenseSrv(ExpenseRpo expenseRpo) {
		this.expenseRpo = expenseRpo;
	}
	
	// returns all the expenses
	public List<ExpenseMdl> allExpense() {
		return expenseRpo.findAll(); 
	}
	
	// creates an expense
	public ExpenseMdl createExpense(ExpenseMdl x) {
		return expenseRpo.save(x); 
	}
	
	// updates an expense
    public ExpenseMdl updateExpense(ExpenseMdl x) {
        return expenseRpo.save(x);
    }
	
	// returns expense by id
	public ExpenseMdl findExpense(Long id) {
		Optional<ExpenseMdl> optionalExpense = expenseRpo.findById(id); 
		if(optionalExpense.isPresent()) {
			return optionalExpense.get(); 
		} else {
			return null; 
		}
	}
	
	// delete expense by id
	public void  delete(Long id) {
			Optional<ExpenseMdl> deleteThisExpenseId = expenseRpo.findById(id); 
			if(deleteThisExpenseId.isPresent()) {
				 expenseRpo.deleteById(id); 
			} else {
				System.out.println("WTF happened here, Jon... "); 
			}
		}
	
	

// end srv
}
