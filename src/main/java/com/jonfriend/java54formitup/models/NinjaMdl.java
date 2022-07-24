package com.jonfriend.java54formitup.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ninja")
public class NinjaMdl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank (message="firstName required.")
    private String firstName;
    
    @NotBlank (message="lastName required.")
    private String lastName;
    
    private int age; 
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
//    @OneToOne(fetch=FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private DojoMdl dojoMdl;
    
    public NinjaMdl() {
        
    }
// getters and setters - start

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public DojoMdl getDojoMdl() {
		return dojoMdl;
	}

	public void setDojoMdl(DojoMdl dojoMdl) {
		this.dojoMdl = dojoMdl;
	}

//	getters and setters - end
    
// end of model
}