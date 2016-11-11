package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.UserSmsCallPackage;;



@Repository("userSmsCallPackageDao")
public class UserSmsCallPackageDaoImpl extends AbstractDao<Integer, UserSmsCallPackage> implements UserSmsCallPackageDao {

	static final Logger logger = LoggerFactory.getLogger(UserSmsCallPackageDaoImpl.class);
	

	public UserSmsCallPackage findById(int id) {
		UserSmsCallPackage userSmsCallPackage = getByKey(id);
		if(userSmsCallPackage!=null){
			//Hibernate.initialize(user.getSmsCallPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return userSmsCallPackage;
	}

	@SuppressWarnings("unchecked")
	public List<UserSmsCallPackage> findAllUsersSmsCallPackage() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserSmsCallPackage> userSmsCallPackages = (List<UserSmsCallPackage>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return userSmsCallPackages;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserSmsCallPackage> findAllUsersSmsCallPackageByUserID(Integer UserID){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", UserID));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserSmsCallPackage> userSmsCallPackages = (List<UserSmsCallPackage>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return userSmsCallPackages;
	}
	@SuppressWarnings("unchecked")
	public UserSmsCallPackage findActivatedUsersSmsCallPackageByUserID(Integer UserID){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userID", UserID));
		criteria.add(Restrictions.eq("activated", true));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserSmsCallPackage> userSmsCallPackages = (List<UserSmsCallPackage>) criteria.list();
		System.out.println("UserID:"+UserID+" List Size:"+userSmsCallPackages.size());
		return userSmsCallPackages.isEmpty()? null: userSmsCallPackages.get(0);
	}
	
	public void save(UserSmsCallPackage userSmsCallPackage) {
		System.out.println(userSmsCallPackage.getUserID().toString());
		persist(userSmsCallPackage);
	}
	
	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		UserSmsCallPackage userSmsCallPackage = (UserSmsCallPackage)crit.uniqueResult();
		delete(userSmsCallPackage);
	}
	
	

}
