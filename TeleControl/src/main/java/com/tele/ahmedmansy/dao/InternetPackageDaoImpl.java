package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.InternetPackage;



@Repository("InternetPackageDao")
public class InternetPackageDaoImpl extends AbstractDao<Integer, InternetPackage> implements InternetPackageDao {

	static final Logger logger = LoggerFactory.getLogger(InternetPackageDaoImpl.class);


	public InternetPackage findById(int id) {
		InternetPackage internetPackage = getByKey(id);
		if(internetPackage!=null){
			//Hibernate.initialize(user.getInternetPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return internetPackage;
	}


	@SuppressWarnings("unchecked")
	public List<InternetPackage> findAllInternetPackage() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<InternetPackage> internetPackages = (List<InternetPackage>) criteria.list();
		
		return internetPackages;
	}

	public void save(InternetPackage internetPackage) {
		persist(internetPackage);
	}


	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		InternetPackage internetPackage = (InternetPackage)crit.uniqueResult();
		delete(internetPackage);
	}
	

}
