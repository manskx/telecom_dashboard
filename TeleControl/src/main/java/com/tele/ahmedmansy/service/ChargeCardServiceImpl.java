package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.ChargeCardDao;
import com.tele.ahmedmansy.model.ChargeCard;


@Service("chargeCardService")
@Transactional
public class ChargeCardServiceImpl implements ChargeCardService{

	@Autowired
	private ChargeCardDao dao;
	
	
	public ChargeCard findById(int id) {
		return dao.findById(id);
	}

	public ChargeCard findByCode(String code) {
		ChargeCard chargeCard = dao.findByCode(code);
		return chargeCard;
	}

	
	public void saveChargeCard(ChargeCard chargeCard) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		chargeCard.setUsed(false);

		dao.save(chargeCard);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateChargeCard(ChargeCard chargeCard) {
		ChargeCard entity = dao.findById(chargeCard.getId());
		if(entity!=null){
			entity.setCode(chargeCard.getCode());
			entity.setValue(chargeCard.getValue());
			entity.setUsed(chargeCard.isUsed());
		}
	}

	public void deleteChargeCardByID(String id){
		dao.deleteByID(id);
	}
	

	public List<ChargeCard> findAllChargeCards() {
		return dao.findAllChargeCard();
	}



}
