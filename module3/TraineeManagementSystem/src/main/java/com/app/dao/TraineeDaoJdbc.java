package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entities.Trainee;
import com.app.util.TraineeMapper;

@Repository
@Profile("jdbc")
public class TraineeDaoJdbc implements TraineeDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TraineeDaoJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(Trainee trainee) {
		jdbcTemplate.update("insert into trainee_table(name,age,marks) values(?,?,?)",
				new Object[] { trainee.getName(), trainee.getAge(), trainee.getMarks() });
	}

	@Override
	public Trainee findById(int traineeId) {
		String sql = "select id, name, age, marks from trainee_table where id = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new TraineeMapper(), traineeId);
		} catch (Exception e) {
			return null;
		}

	}

}