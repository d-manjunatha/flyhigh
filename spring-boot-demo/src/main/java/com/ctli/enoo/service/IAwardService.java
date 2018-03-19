package com.ctli.enoo.service;

import java.util.List;

import com.ctli.enoo.entity.Award;

public interface IAwardService {
     List<Award> getAllAwards();
     Award getAwardById(int awardId);
     boolean addAward(Award award);
     void updateAward(Award award);
     void deleteAward(int awardId);

}
