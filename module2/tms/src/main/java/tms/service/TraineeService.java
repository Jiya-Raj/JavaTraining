package tms.service;

import tms.dto.Trainee;

public interface TraineeService {
	public void addTrainee(Trainee trainee);

	public Trainee findTraineeById(int traineeId); 
}
