package com.example.TraineeMngSystem.service;

import java.util.*;

import com.example.TraineeMngSystem.entities.Trainee;

public interface TraineeService {
	public List<Trainee> getAll();

	public Trainee addTrainee(Trainee trainee);

	public Trainee getById(int id);
	
	public Trainee updateTrainee(int id,Trainee trainee);
	
	public Trainee DeleteTrainee(int id);
	
	public List<Trainee> getByName();
}
