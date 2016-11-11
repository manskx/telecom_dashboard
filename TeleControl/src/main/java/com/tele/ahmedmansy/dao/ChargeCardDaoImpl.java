package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.ChargeCard;
import com.tele.ahmedmansy.model.User;



@Repository("ChargeCardDao")
public class ChargeCardDaoImpl extends AbstractDao<Integer, ChargeCard> implements ChargeCardDao {

	static final Logger logger = LoggerFactory.getLogger(ChargeCardDaoImpl.class);


	public ChargeCard findById(int id) {
		ChargeCard chargeCard = getByKey(id);
		if(chargeCard!=null){

		}
		return chargeCard;
	}

	public ChargeCard findByCode(String code) {
		logger.info("code : {}", code);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("code", code));
		ChargeCard chargeCard = (ChargeCard)crit.uniqueResult();
		if(chargeCard!=null){

		}
		return chargeCard;
	}

	@SuppressWarnings("unchecked")
	public List<ChargeCard> findAllChargeCard() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ChargeCard> chargeCards = (List<ChargeCard>) criteria.list();
		
		return chargeCards;
	}

	public void save(ChargeCard chargeCards) {
		persist(chargeCards);
	}


	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		ChargeCard chargeCard = (ChargeCard)crit.uniqueResult();
		delete(chargeCard);
	}
	

}
