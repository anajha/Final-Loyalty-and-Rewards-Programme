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
@Table(name="masttran")
public class MastTran {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     
    public Long id;
    
    @Column(name="PAN")
    public Long pan;
  
    @Column(name="MERCHANTID")
    public Long merchid;
    
    @Column(name="TRANAMT")
    public Integer tranamt;
    
    @Column(name="TRANPAID")
    public Integer tranpaid;
    
	@Column(name="WALLVAL")
    public Integer wallval;
    
    @Column(name="WALLPAID")
    public Integer wallpaid;
    
    @Column(name="WALLVALBEFORE")
    public Integer wallvalbefore;
    
    @Column(name="WALLVALAFTER")
    public Integer wallvalafter;
    
    @Column(name = "TIMESTMP", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date timestmp;
    
    @Column(name="STATUS")
    public String status;
    
    @Column(name="STATREASON")
    public String statreason;
    
    
    //no-args constructor
    public MastTran()
    {}
    
    public MastTran(Long pan,Long merchid,Integer tranamt,Integer tranpaid,Integer wallval,Integer wallpaid,Integer wallvalbefore,Integer wallvalafter,String status,String statreason)
    
    {
    	
    	this.pan = pan;
    	this.merchid = merchid;
    	this.tranamt = tranamt;
    	this.tranpaid= tranpaid;
    	this.wallval= wallval;
    	this.wallpaid= wallpaid;
    	this.wallvalbefore=wallvalbefore;
    	this.wallvalafter=wallvalafter;
    	timestmp=new Date();
    	this.status=status;   	
    	this.statreason=statreason;
    }
    
    public String getStatreason() {
		return statreason;
	}

	public void setStatreason(String statreason) {
		this.statreason = statreason;
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

	public Long getMerchid() {
		return merchid;
	}

	public void setMerchid(Long merchid) {
		this.merchid = merchid;
	}

	public Integer getTranamt() {
		return tranamt;
	}

	public void setTranamt(Integer tranamt) {
		this.tranamt = tranamt;
	}

	public Integer getTranpaid() {
		return tranpaid;
	}

	public void setTranpaid(Integer tranpaid) {
		this.tranpaid = tranpaid;
	}
	
	public Integer getWallval() {
		return wallval;
	}

	public void setWallval(Integer wallval) {
		this.wallval = wallval;
	}

	public Integer getWallpaid() {
		return wallpaid;
	}

	public void setWallpaid(Integer wallpaid) {
		this.wallpaid = wallpaid;
	}
	
	public Integer getWallvalbefore() {
			return wallvalbefore;
		}

	public void setWallvalbefore(Integer wallvalbefore) {
			this.wallvalbefore = wallvalbefore;
		}

	public Integer getWallvalafter() {
			return wallvalafter;
		}

	public void setWallvalafter(Integer wallvalafter) {
			this.wallvalafter = wallvalafter;
		}
	public Date getTimestmp() {
		return timestmp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
