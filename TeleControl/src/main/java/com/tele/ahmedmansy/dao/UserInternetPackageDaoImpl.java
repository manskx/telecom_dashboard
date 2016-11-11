package com.tele.ahmedmansy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tele.ahmedmansy.model.UserInternetPackage;;



@Repository("userInternetPackageDao")
public class UserInternetPackageDaoImpl extends AbstractDao<Integer, UserInternetPackage> implements UserInternetPackageDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	

	public UserInternetPackage findById(int id) {
		UserInternetPackage userInternetPackage = getByKey(id);
		if(userInternetPackage!=null){
			//Hibernate.initialize(user.getInternetPackage());
			//Hibernate.initialize(user.getCallsPackage());
		}
		return userInternetPackage;
	}

	@SuppressWarnings("unchecked")
	public List<UserInternetPackage> findAllUsersInternetPackage() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserInternetPackage> userInternetPackages = (List<UserInternetPackage>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return userInternetPackages;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInternetPackage> findAllUsersInternetPackageByUserID(Integer UserID){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", UserID));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserInternetPackage> userInternetPackages = (List<UserInternetPackage>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return userInternetPackages;
	}
	@SuppressWarnings("unchecked")
	public UserInternetPackage findActivatedUsersInternetPackageByUserID(Integer UserID){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userID", UserID));
		criteria.add(Restrictions.eq("activated", true));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<UserInternetPackage> userInternetPackages = (List<UserInternetPackage>) criteria.list();
		System.out.println("UserID:"+UserID+" List Size:"+userInternetPackages.size());
		return userInternetPackages.isEmpty()? null: userInternetPackages.get(0);
	}
	
	public void save(UserInternetPackage userInternetPackage) {
		System.out.println(userInternetPackage.getUserID().toString());
		persist(userInternetPackage);
	}
	
	public void deleteByID(String id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		UserInternetPackage userInternetPackage = (UserInternetPackage)crit.uniqueResult();
		delete(userInternetPackage);
	}
	
	

}
