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
@Table(name="findcreate")
public class FindCreate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    public Long id;
    
    @Column(name="PAN")
    public Long pan;
  
	@Column(name="TRANTYPE")
    public String trantype;
    
    @Column(name="AMOUNT")
    public Integer amount;
     
    @Column(name = "TIMESTMP", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date timestmp;
    
    
    //no-args constructor
    public FindCreate()
    {}
    
    public FindCreate(Long pan, String trantype,Integer amount)
    
    {
    	
    	this.pan = pan;
    	this.trantype=trantype;
    	this.amount=amount;
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

	public String getTrantype() {
		return trantype;
	}

	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getTimestmp() {
		return timestmp;
	}
}
    
    