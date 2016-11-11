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

@Entity
@Table(name="tele_chargecards")
public class ChargeCard implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="code", unique=true, nullable=false)
	private String code;
	
	@NotNull
	@Column(name="value", nullable=false)
	private Integer value;
		

	@Column(name="used", nullable=false)
	private boolean used;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String Code) {
		this.code = Code;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer Value) {
		this.value = Value;
	}

	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean Used) {
		this.used = Used;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ChargeCard))
			return false;
		ChargeCard other = (ChargeCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Charge Card [id=" + id + ", value=" + value + ", code=" + code
				+ ", is used=" + used + "]";
	}
	
}
