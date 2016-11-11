package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.SmsCallPackage;;



@Repository("SmsCallPackageDao")
public class SmsCallPackageDaoImpl extends AbstractDao<Integer, SmsCallPackage> implements SmsCallPackageDao {

	static final Logger logger = LoggerFactory.getLogger(SmsCallPackageDaoImpl.class);


	public SmsCallPackage findById(int id) {
		SmsCallPackage smsCallPackage = getByKey(id);
		if(smsCallPackage!=null){
			//Hibernate.initialize(user.getSmsCallPackage());
			//Hibernate.initialize(user.getSmsCallPackage());
		}
		return smsCallPackage;
	}


	@SuppressWarnings("unchecked")
	public List<SmsCallPackage> findAllSmsCallPackage() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<SmsCallPackage> smsCallPackages = (List<SmsCallPackage>) criteria.list();
		
		return smsCallPackages;
	}

	public void save(SmsCallPackage smsCallPackage) {
		persist(smsCallPackage);
	}


	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		SmsCallPackage smsCallPackage = (SmsCallPackage)crit.uniqueResult();
		delete(smsCallPackage);
	}
	

}
