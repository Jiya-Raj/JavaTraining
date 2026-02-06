package com.example.TraineeMngSystem.dto;

public class TraineeDto {
	private Integer id;
	private String name;
	private Integer marks;
	private Integer age;

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getMarks() {
		return marks;
	}

	public Integer getId() {
		return id;
	}

	public TraineeDto() {

	}

	public TraineeDto(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
