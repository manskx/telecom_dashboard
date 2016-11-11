package com.tele.ahmedmansy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tele_user_smscallpackage")
public class UserSmsCallPackage implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	
	
	@Column(name="activated", nullable=false)
	private boolean activated;
	
	@Column(name = "registered_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date RegDate;
	
	@Column(name = "user_id")
	private Integer userID;
	
	@Column(name = "smscallpackage_id")
	private Integer smscallpackageID;
	 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Integer getUserID() {
        return userID;
    }
 
    public void setUserID(Integer userid) {
        this.userID = userid;
    }
    
  
    public Integer getSmsCallPackageID() {
        return smscallpackageID;
    }
 
    public void setSmsCallPackageID(Integer SmsCallPackageID) {
        this.smscallpackageID = SmsCallPackageID;
    }
 
    public boolean isActivated() {
        return activated;
    }
 
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
	public Date getRegDate() {
		return RegDate;
	}

	public void setRegDate(Date reg_date) {
		this.RegDate = reg_date;
	}
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserSmsCallPackage))
			return false;
		UserSmsCallPackage other = (UserSmsCallPackage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}


	@Override
	public String toString() {
		return "UserSMSCallPackage [id=" + id + "UserID="+ userID+" smscallpackageID="+smscallpackageID+" activated="+activated+"]";
	}


	
}
