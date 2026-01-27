package tms.service;

import tms.dao.TraineeDao;
import tms.dao.TraineeJdbcDao;
import tms.dao.TraineeJpaDao;
import tms.dto.Trainee;
import tms.exception.DaoException;
import tms.exception.ServiceException;

public class TraineeServiceImpl implements TraineeService {
	private TraineeDao traineedao;

	public TraineeServiceImpl() {
		this.traineedao = new TraineeJdbcDao();
	}

	@Override
	public void addTrainee(Trainee trainee) {
		if (trainee == null)
			throw new ServiceException("Given Trainee is invalid");

		if (trainee.getTrainee_name() == null || trainee.getTrainee_name().isEmpty()) {
			throw new ServiceException("Trainee Name can not be empty");
		}

		if (trainee.getBranch() == null || trainee.getBranch().isEmpty()) {
			throw new ServiceException("Branch can not be empty");
		}

		try {
			traineedao.addTrainee(trainee);
		} catch (DaoException e) {
			throw new ServiceException("Facing problems adding Trainee", e);
		}

	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		if (traineeId <= 0) {
			throw new ServiceException("Trainee Id is invalid");
		}

		Trainee trainee = null;
		try {
			trainee = traineedao.findTraineeById(traineeId);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return trainee;
	}

}
