package com.tele.ahmedmansy.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tele.ahmedmansy.dao.SmsCallPackageDao;
import com.tele.ahmedmansy.model.SmsCallPackage;


@Service("smsCallPackageService")
@Transactional
public class SmsCallPackageServiceImpl implements SmsCallPackageService{

	@Autowired
	private SmsCallPackageDao dao;

	
	
	public SmsCallPackage findById(int id) {
		return dao.findById(id);
	}


	public void saveSmsCallPackage(SmsCallPackage smsCallPackage) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		dao.save(smsCallPackage);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateSmsCallPackage(SmsCallPackage smsCallPackage) {
		SmsCallPackage entity = dao.findById(smsCallPackage.getId());
		if(entity!=null){
			entity.setDes(smsCallPackage.getDes());
			entity.setFees(smsCallPackage.getFees());
			entity.setDuration(smsCallPackage.getDuration());
			entity.setCall(smsCallPackage.getCall());
			entity.setSms(smsCallPackage.getSms());
			
		}
	}

	public void deleteSmsCallPackageByID(String id){
		dao.deleteByID(id);
	}

	public List<SmsCallPackage> findAllSmsCallPackages() {
		return dao.findAllSmsCallPackage();
	}


	
}
