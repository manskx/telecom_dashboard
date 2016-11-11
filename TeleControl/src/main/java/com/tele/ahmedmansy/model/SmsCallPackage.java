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
@Table(name="tele_smscallpackage")
public class SmsCallPackage implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	@NotNull
	@Column(name="fees", nullable=false)
	private Integer fees;
		
	@NotNull
	@Column(name="sms", nullable=false)
	private Integer 	sms;

	@NotNull
	@Column(name="call", nullable=false)
	private Integer 	call;
	
	@NotEmpty
	@Column(name="des", unique=true, nullable=false)
	private String 	des;

	@NotNull
	@Column(name="duration", nullable=false)
	private Integer duration;
	
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFees() {
		return fees;
	}

	public void setFees(Integer Fees) {
		this.fees = Fees;
	}

	public Integer getSms() {
		return sms;
	}

	public void setSms(Integer SMS) {
		this.sms = SMS;
	}
	
	public Integer getCall() {
		return call;
	}

	public void setCall(Integer Call) {
		this.call = Call;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}
	
	public String getDes() {
		return des;
	}

	public void setDes(String Des) {
		this.des = Des;
	}

	
	
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer Duration) {
		this.duration = Duration;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((fees == null) ? 0 : fees.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SmsCallPackage))
			return false;
		SmsCallPackage other = (SmsCallPackage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (fees == null) {
			if (other.fees != null)
				return false;
		} else if (!sms.equals(other.sms))
			return false;
		return true;
	}

	/*
	 * DO-NOT-INCLUDE passwords in toString function.
	 * It is done here just for convenience purpose.
	 */
	@Override
	public String toString() {
		return "SmsCallPackage [id=" + id + ", fees=" + fees + ", duration=" + duration
				+ ", name=" + name 
				+ ", sms=" + sms +", call=" + call+ "]";
	}


	
}
