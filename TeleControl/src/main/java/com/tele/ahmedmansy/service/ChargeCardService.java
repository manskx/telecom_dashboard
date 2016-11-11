package com.tele.ahmedmansy.service;

import java.util.List;

import com.tele.ahmedmansy.model.ChargeCard;


public interface ChargeCardService {
	
	ChargeCard findById(int id);
	
	ChargeCard findByCode(String code);
	
	void saveChargeCard(ChargeCard chargeCard);
	
	void updateChargeCard(ChargeCard chargeCard);
	
	void deleteChargeCardByID(String id);

	List<ChargeCard> findAllChargeCards(); 
	
	
}