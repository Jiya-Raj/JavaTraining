package tms.dao;

import tms.util.EntityManFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import tms.dto.Trainee;
import tms.exception.DaoException;

public class TraineeJpaDao implements TraineeDao {

	@Override
	public void addTrainee(Trainee trainee) {
		EntityManager em = EntityManFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(trainee);
			tx.commit();
		} catch (PersistenceException e) {
			throw new DaoException("Erro adding Trainee", e);
		}

	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		EntityManager em = EntityManFactory.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Trainee trainee = null;
		try {
			trainee = em.find(Trainee.class, traineeId);
		} catch (PersistenceException e) {
			throw new DaoException("Error Fetching Trainee", e);
		}
		return trainee;
	}

}
