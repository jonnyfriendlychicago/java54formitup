package com.jonfriend.java54formitup.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="person")
public class PersonMdl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @NotBlank (message="firstName required.")
    private String firstName;
    
    @NotBlank (message="lastName required.")
    private String lastName;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(mappedBy="personMdl", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private LicenseMdl licenseMdl;
    
    public PersonMdl() {
        
    }

    // getters and setters
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	//////////////////////////////////
	public LicenseMdl getLicenseMdl() {
		return licenseMdl;
	}

	public void setLicenseMdl(LicenseMdl licenseMdl) {
		this.licenseMdl = licenseMdl;
	}

	
// end of model
}