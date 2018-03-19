package com.ctli.enoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctli.enoo.dao.IAwardDAO;
import com.ctli.enoo.entity.Award;
@Service
public class AwardService implements IAwardService {
	@Autowired
	private IAwardDAO awardDAO;
	@Override
	public Award getAwardById(int awardId) {
		return awardDAO.getAwardById(awardId);
	}	
	@Override
	public List<Award> getAllAwards(){
		return awardDAO.getAllAwards();
	}
	@Override
	public synchronized boolean addAward(Award award){
       if (awardDAO.awardExists(award.getName())) {
    	   return false;
       } else {
    	   awardDAO.addAward(award);
    	   return true;
       }
	}
	@Override
	public void updateAward(Award award) {
		awardDAO.updateAward(award);
	}
	@Override
	public void deleteAward(int awardId) {
		awardDAO.deleteAward(awardId);
	}
	

}
