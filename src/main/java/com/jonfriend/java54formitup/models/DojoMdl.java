package com.jonfriend.java54formitup.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="dojo")
public class DojoMdl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @NotBlank (message="dojoName required.")
    private String dojoName;

//    @NotBlank (message="lastName required.")
//    private String lastName;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
//  @OneToOne(mappedBy="dojoMdl", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @OneToMany(mappedBy="dojoMdl", fetch = FetchType.LAZY)
//  private NinjaMdl ninjaMdl;
    private List<NinjaMdl> ninjaList; 
    
    public DojoMdl() {
        
    }
    // getters and setters - start

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDojoName() {
		return dojoName;
	}

	public void setDojoName(String dojoName) {
		this.dojoName = dojoName;
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

	public List<NinjaMdl> getNinjaList() {
		return ninjaList;
	}

	public void setNinjaList(List<NinjaMdl> ninjaList) {
		this.ninjaList = ninjaList;
	}
    
    
    // getters and setters - end
    
		
// end of model
}