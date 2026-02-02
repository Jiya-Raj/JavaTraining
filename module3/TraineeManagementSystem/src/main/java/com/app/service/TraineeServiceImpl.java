package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dao.TraineeDao;
import com.app.dto.TraineeDto;
import com.app.entities.Trainee;
import com.app.util.TraineeConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {

	private final TraineeDao dao;

	public TraineeServiceImpl(TraineeDao dao) {
		this.dao = dao;
	}

	@Override
	public void addTrainee(TraineeDto traineeDto) {
		dao.save(TraineeConverter.convertToTrainee(traineeDto));

	}

	@Override
	public TraineeDto findById(int traineeId) {
		Trainee trainee=dao.findById(traineeId);
		return TraineeConverter.convertToTraineeDto(trainee);
	}

}
