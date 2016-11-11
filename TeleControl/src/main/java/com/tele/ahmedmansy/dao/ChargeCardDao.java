package com.tele.ahmedmansy.dao;

import java.util.List;

import com.tele.ahmedmansy.model.ChargeCard;


public interface ChargeCardDao {

	ChargeCard findById(int id);
	
	void save(ChargeCard chargeCard);
	
	ChargeCard findByCode(String code);
	
	void deleteByID(String id);
	
	List<ChargeCard> findAllChargeCard();

}

