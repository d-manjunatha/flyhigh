package com.ctli.enoo.dao;
import java.util.List;

import com.ctli.enoo.entity.Award;
public interface IAwardDAO {
    List<Award> getAllAwards();
    Award getAwardById(int awardId);
    void addAward(Award award);
    void updateAward(Award award);
    void deleteAward(int awardId);
    boolean awardExists(String email);
}
 