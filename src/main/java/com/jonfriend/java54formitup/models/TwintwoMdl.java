package com.jonfriend.java54formitup.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; // JRF manually adding
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
//JRF: keep below OUT when building the autoJoinTbl solution
//import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
@Table(name="twintwo")
public class TwintwoMdl {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // begin: entity-specific table fields
   
    private String twintwoName;
    
    // end: entity-specific table fields
    
    // start: code for automatically-created join table
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "twintwo_twinone", 
        joinColumns = @JoinColumn(name = "twintwo_id"), 
        inverseJoinColumns = @JoinColumn(name = "twinone_id")
    )
    
    private List<TwinoneMdl> twinoneMdl;
    
    // end: code for automatically-created join table
    
    // instantiate the model: 
    public TwintwoMdl() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // getters and setters - start
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTwintwoName() {
		return twintwoName;
	}
	public void setTwintwoName(String twintwoName) {
		this.twintwoName = twintwoName;
	}
	public List<TwinoneMdl> getTwinoneMdl() {
		return twinoneMdl;
	}
	public void setTwinoneMdl(List<TwinoneMdl> twinoneMdl) {
		this.twinoneMdl = twinoneMdl;
	}

    // getters and setters - end
    
// end mdl
}