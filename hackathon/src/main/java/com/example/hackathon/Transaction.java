package com.example.hackathon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    public Long id;
    
    @Column(name="PAN")
    public Long pan;
  
    @Column(name="POINTS")
    public Integer points;
    
    @Column(name="REWARDVALUE")
    public Integer value;
    
    public Long getid() {
		return id;
	}
    
    //no-args constructor
    public Transaction()
    {}
    
    public Transaction(Long pan,Integer points,Integer value)
    
    {
    	
    	this.pan = pan;
    	this.points = points;
    	this.value = value;
    	
    }

	public void setid(Long id) {
		this.id = id;
	}

	public Long getpan() {
		return pan;
	}

	public void setpan(Long pan) {
		this.pan = pan;
	}

	public Integer getpoints() {
		return points;
	}

	public void setpoints(Integer points) {
		this.points = points;
	}
	
	public Integer getvalue() {
		return value;
	}

	public void setvalue(Integer value) {
		this.value = value;
	}


}