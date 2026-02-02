package com.app.util;

import com.app.dto.TraineeDto;
import com.app.entities.Trainee;

public class TraineeConverter {
	public static TraineeDto convertToTraineeDto(Trainee trainee) {

		if (trainee == null) {
			return null;
		}

		TraineeDto dto = new TraineeDto();
		dto.setName(trainee.getName());
		dto.setAge(trainee.getAge());
		dto.setMarks(trainee.getMarks());

		return dto;
	}

	public static Trainee convertToTrainee(TraineeDto dto) {

		if (dto == null) {
			return null;
		}

		Trainee trainee = new Trainee();
		trainee.setName(dto.getName());
		trainee.setAge(dto.getAge());
		trainee.setMarks(dto.getMarks());

		return trainee;
	}
}
