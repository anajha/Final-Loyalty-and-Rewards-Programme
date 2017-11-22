package com.example.hackathon;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="cardlog")
public class CardMerchLog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    public Long id;
    
    @Column(name="PAN")
    public Long pan;
  
	@Column(name="ACTIVITY")
    public String activity;
     
	@Column(name = "TIMESTMP", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date timestmp;
    
    
    
    //no-args constructor
    public CardMerchLog()
    {}
    
    public CardMerchLog(Long pan, String activity)
    
    {
    	
    	this.pan = pan;
    	this.activity=activity;
    	timestmp=new Date();
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPan() {
		return pan;
	}

	public void setPan(Long pan) {
		this.pan = pan;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getTimestmp() {
		return timestmp;
	}
    
}