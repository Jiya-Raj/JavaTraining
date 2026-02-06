package com.app.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.app.entities.Trainee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
//@Primary
public class TraineeDaoJpa implements TraineeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Trainee trainee) {
		em.persist(trainee);

	}

	@Override
	public Trainee findById(int traineeId) {

		return em.find(Trainee.class, traineeId);
	}

}
