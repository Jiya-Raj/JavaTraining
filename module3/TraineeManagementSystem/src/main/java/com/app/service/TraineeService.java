package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dto.TraineeDto;


public interface TraineeService {
	void addTrainee(TraineeDto traineeDto);

	TraineeDto findById(int traineeId);
}
