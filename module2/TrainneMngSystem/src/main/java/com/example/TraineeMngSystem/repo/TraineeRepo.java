package com.example.TraineeMngSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.TraineeMngSystem.entities.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee,Integer>{
	
	@Query("select t from Trainee t where name=:name")
	public List<Trainee>findByName(@Param("name") String name);

}
