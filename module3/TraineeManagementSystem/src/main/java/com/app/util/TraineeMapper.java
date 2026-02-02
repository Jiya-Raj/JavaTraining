package com.app.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.entities.Trainee;

public class TraineeMapper implements RowMapper<Trainee> {
	
	@Override
	public Trainee mapRow(ResultSet rs,int rowNum) throws SQLException{
	 return new Trainee(rs.getString("name"),rs.getInt("age"),rs.getInt("marks"));	
	}
 
}
