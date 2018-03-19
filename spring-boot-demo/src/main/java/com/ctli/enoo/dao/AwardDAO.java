package com.ctli.enoo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctli.enoo.entity.Award;
@Transactional
@Repository
public class AwardDAO implements IAwardDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Award getAwardById(int awardId) {
		return entityManager.find(Award.class, awardId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Award> getAllAwards() {
		String hql = "FROM Award as atcl ORDER BY atcl.id";
		return (List<Award>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addAward(Award award) {
		entityManager.persist(award);
	}
	@Override
	public void updateAward(Award award) {
		Award e = getAwardById(award.getId());
		e.setName(award.getName());
		e.setDesc(award.getDesc());
		entityManager.flush();
	}
	@Override
	public void deleteAward(int awardId) {
		entityManager.remove(getAwardById(awardId));
	}
	@Override
	public boolean awardExists(String name) {
		String hql = "FROM Award WHERE name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
