package tms.controller;

import com.google.protobuf.ServiceException;

import tms.dao.TraineeDao;
import tms.dao.TraineeJdbcDao;
import tms.dao.TraineeJpaDao;
import tms.dto.Trainee;
import tms.service.TraineeService;
import tms.service.TraineeServiceImpl;
import tms.util.ConnectionFactory;

public class TraineeManagementSystem {
	TraineeService traineeservice;

	TraineeManagementSystem() {
		TraineeDao traineedao = new TraineeJdbcDao();
		this.traineeservice = new TraineeServiceImpl();
		// traineedao = new TraineeJpaDao();
	}

	public static void main(String[] args) {
		new TraineeManagementSystem().TMS();
	}

	public void TMS() {
		try {
			//traineeservice.addTrainee(new Trainee("AnshJpa", "IT", 55.0));
			System.out.println(traineeservice.findTraineeById(12));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
