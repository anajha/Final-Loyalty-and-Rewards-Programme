package com.example.hackathon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    public Long id;
    
    @Column(name="MERCHANTID")
    public Long merchid;
  
    @Column(name="MERCHANTNAME")
    public String merchname;
    
    @Column(name="MERCHANTRATE")
    public Integer mrate;
    
    public Long getid() {
		return id;
	}
    
    //no-args constructor
    public Merchant()
    {}
    
    public Merchant(Long merchid,String merchname,Integer mrate)
    
    {
    	
    	this.merchid = merchid;
    	this.merchname = merchname;
    	this.mrate = mrate;
    	
    }

	public void setid(Long id) {
		this.id = id;
	}

	public Long getmerchid() {
		return merchid;
	}

	public void setmerchid(Long merchid) {
		this.merchid = merchid;
	}

	public String getmerchname() {
		return merchname;
	}

	public void setmerchname(String merchname) {
		this.merchname = merchname;
	}
	
	public Integer getmrate() {
		return mrate;
	}

	public void setmrate(Integer mrate) {
		this.mrate = mrate;
	}


}
