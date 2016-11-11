package com.tele.ahmedmansy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tele_user")
public class User implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="phone_id", unique=true, nullable=false)
	private String phoneID;
	
	@NotEmpty
	@Column(name="password", nullable=false)
	private String password;
		
	@NotEmpty
	@Column(name="name", nullable=false)
	private String name;

	@NotEmpty
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@NotEmpty
	@Column(name="lostpassanswer", nullable=false)
	private String lostpassanswer;

	@NotEmpty
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name = "reg_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date RegDate;
	
	
	
	@NotNull
	@Column(name="credit")
	private Integer credit;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(String phone_id) {
		this.phoneID = phone_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getLostpassanswer() {
		return lostpassanswer;
	}

	public void setLostpassanswer(String Lostpassanswer) {
		this.lostpassanswer = Lostpassanswer;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String Type) {
		this.type = Type;
	}
	
	
	public Integer getCredit() {
		return credit;
	}
	
	public void setCredit(Integer Credit) {
		this.credit = Credit;
	}
	
	
	
	public Date getRegDate() {
		return RegDate;
	}

	public void setRegDate(Date reg_date) {
		this.RegDate = reg_date;
	}
	
/*	
	  @OneToMany(mappedBy = "tele_user")
	    public Set<UserInternetPackage> getUserInternetPackages() {
	        return userInternetPackages;
	    }
	 
	    public void setUserInternetPackages(Set<UserInternetPackage> userInternetpackages) {
	        this.userInternetPackages = userInternetpackages;
	    }
	     
	    public void addUserInternetPackage(UserInternetPackage userInternetpackage) {
	        this.userInternetPackages.add(userInternetpackage);
	    } 
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phoneID == null) ? 0 : phoneID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phoneID == null) {
			if (other.phoneID != null)
				return false;
		} else if (!phoneID.equals(other.phoneID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", phoneID=" + phoneID + ", password=" + password
				+ ", name=" + name 
				+ ", email=" + email +"Lost Password="+lostpassanswer+" Credit="+credit+"]";
	}


	
}
