package com.app.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.app.entities.Trainee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Profile("jpa")
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
