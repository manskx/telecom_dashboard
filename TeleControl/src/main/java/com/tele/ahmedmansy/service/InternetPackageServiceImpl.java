package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.InternetPackageDao;
import com.tele.ahmedmansy.model.InternetPackage;;


@Service("internetPackageService")
@Transactional
public class InternetPackageServiceImpl implements InternetPackageService{

	@Autowired
	private InternetPackageDao dao;

	
	
	public InternetPackage findById(int id) {
		return dao.findById(id);
	}


	public void saveInternetPackage(InternetPackage internetPackage) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		
		
		dao.save(internetPackage);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateInternetPackage(InternetPackage internetPackage) {
		InternetPackage entity = dao.findById(internetPackage.getId());
		if(entity!=null){
			entity.setDes(internetPackage.getDes());
			entity.setFees(internetPackage.getFees());
			entity.setDuration(internetPackage.getDuration());
			entity.setQuota(internetPackage.getQuota());
		}
	}

	public void deleteInternetPackageByID(String id){
		dao.deleteByID(id);
	}

	public List<InternetPackage> findAllInternetPackages() {
		return dao.findAllInternetPackage();
	}


	
}
