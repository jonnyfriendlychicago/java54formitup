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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="publication")
public class PublicationMdl {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // begin: entity-specific table fields
    
    @NotBlank (message="pubTitle required.")
    private String pubTitle;
    
    @NotBlank (message="pubAuthor required.")
    private String pubAuthor;
    
    @NotBlank (message="thoughtsOnPub required.")
    private String thoughtsOnPub;
    
//    private int age; 
    
//    @Column(updatable=false)
//    private Date createdAt;
//    private Date updatedAt;
    
    
//    @OneToOne(fetch=FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
    @JoinColumn(name="createdby_id")
    private UserMdl userMdl;

    // end: entity-specific table fields
    
    // instantiate the model: 
    public PublicationMdl() {}
    
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

	public String getPubTitle() {
		return pubTitle;
	}

	public void setPubTitle(String pubTitle) {
		this.pubTitle = pubTitle;
	}

	public String getPubAuthor() {
		return pubAuthor;
	}

	public void setPubAuthor(String pubAuthor) {
		this.pubAuthor = pubAuthor;
	}

	public String getThoughtsOnPub() {
		return thoughtsOnPub;
	}

	public void setThoughtsOnPub(String thoughtsOnPub) {
		this.thoughtsOnPub = thoughtsOnPub;
	}

	public UserMdl getUserMdl() {
		return userMdl;
	}

	public void setUserMdl(UserMdl userMdl) {
		this.userMdl = userMdl;
	}
    

    
//	getters and setters - end
    
// end of model
}