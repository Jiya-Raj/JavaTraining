package com.app.dao;

import org.springframework.stereotype.Repository;

import com.app.entities.Trainee;


public interface TraineeDao {
	void save(Trainee trainee);

	Trainee findById(int traineeId);
}
