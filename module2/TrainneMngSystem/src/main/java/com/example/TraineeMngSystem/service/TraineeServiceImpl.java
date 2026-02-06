package com.example.TraineeMngSystem.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TraineeMngSystem.entities.Trainee;
import com.example.TraineeMngSystem.exception.ResourceNotFoundException;
import com.example.TraineeMngSystem.repo.TraineeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {

	private TraineeRepo traineeRepo;
	
	@Autowired
	public TraineeServiceImpl(TraineeRepo traineeRepo) {
		this.traineeRepo=traineeRepo;
	}

	@Override
	public List<Trainee> getAll() {
		return traineeRepo.findAll();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeRepo.save(trainee);
	}

	@Override
	public Trainee getById(int id) {
		return traineeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Trainee Not Found"));
	}

	@Override
	public Trainee updateTrainee(int id, Trainee trainee) {
		Trainee traineeToUpdate=getById(id);
		traineeToUpdate.setMarks(trainee.getMarks());
		traineeRepo.save(traineeToUpdate);
		return traineeToUpdate;
	}

	@Override
	public Trainee DeleteTrainee(int id) {
		Trainee traineeToDelete=getById(id);
		traineeRepo.delete(traineeToDelete);;
		return traineeToDelete;
	}

	@Override
	public List<Trainee> getByName(String name) {
		
		return traineeRepo.findByName(name);
	}

}
