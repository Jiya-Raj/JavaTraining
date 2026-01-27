package tms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Trainee {
	@Id
	private int trainee_id;
	private String trainee_name;
	private String branch;
	private double percentage;

	public Trainee() {

	}

	public Trainee(int trainee_id, String trainee_name, String branch, double percentage) {
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee(String trainee_name, String branch, double percentage) {
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int id) {
		this.trainee_id = id;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Trainee Details id: " + this.getTrainee_id() + " Name: " + this.getTrainee_name() + " Branch: "
				+ this.getBranch() + " %: " + this.getPercentage();
	}

}
