package tms.dao;

import tms.dto.Trainee;

public interface TraineeDao {

	public void addTrainee(Trainee trainee);

	public Trainee findTraineeById(int traineeId);
}
