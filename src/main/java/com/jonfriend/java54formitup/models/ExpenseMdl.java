package com.jonfriend.java54formitup.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expense")

public class ExpenseMdl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotBlank (message="Expense name required.")
	private String expenseName; 
	
	@NotBlank (message="Vendor name required.")
	private String vendorName; 
	
	@NotNull (message="Expense amount required.")
//	@Min(value = (long) 0.01, message="Expense must be $0.01 or greater.")
//	JRF: above is bogus for double use, use below
	@DecimalMin(value = "0.01", message = "Your message...")
	private Double expenseAmount;
	
	@NotBlank(message="Expense description required.")
	private String expenseDescription; 
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public ExpenseMdl() {
	}
	public ExpenseMdl(
			String expenseName
			, String vendorName
			, Double expenseAmount
			, String expenseDescription
			) {
		this.expenseName = expenseName; 
		this.vendorName = vendorName; 
		this.expenseAmount = expenseAmount; 
		this.expenseDescription = expenseDescription; 
	}
	
	   @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getExpenseName() {
			return expenseName;
		}
		public void setExpenseName(String expenseName) {
			this.expenseName = expenseName;
		}
		public String getVendorName() {
			return vendorName;
		}
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}
		public Double getExpenseAmount() {
			return expenseAmount;
		}
		public void setExpenseAmount(Double expenseAmount) {
			this.expenseAmount = expenseAmount;
		}
		public String getExpenseDescription() {
			return expenseDescription;
		}
		public void setExpenseDescription(String expenseDescription) {
			this.expenseDescription = expenseDescription;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	
// end of model class
}
