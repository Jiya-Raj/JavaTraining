package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TraineeDto;
import com.app.service.TraineeService;

@RestController
public class TraineeController {
 private TraineeService service;
 
 public TraineeController(TraineeService service) {
	 this.service=service;
 }
 
 @PostMapping("/trainees")
 public ResponseEntity<Void> addTrainee(@RequestBody TraineeDto dto){
	 service.addTrainee(dto);
	 return ResponseEntity.status(HttpStatus.CREATED).build();
 }
 
 @GetMapping("/trainees/{id}")
 public ResponseEntity<TraineeDto> getById(@PathVariable Integer id){
	 return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
 }
}
