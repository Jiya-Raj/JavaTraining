package tms.dao;

import java.sql.*;

import tms.dto.Trainee;
import tms.exception.DaoException;
import tms.util.ConnectionFactory;

public class TraineeJdbcDao implements TraineeDao {
	private Connection connection;

	public TraineeJdbcDao() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addTrainee(Trainee trainee) {
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"insert into trainee(trainee_name,branch,percentage) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			psmt.setString(1, trainee.getTrainee_name());
			psmt.setString(2, trainee.getBranch());
			psmt.setDouble(3, trainee.getPercentage());

			psmt.executeUpdate();

			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				trainee.setTrainee_id(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DaoException("Error adding Trainee", e);
		}
	}

	@Override
	public Trainee findTraineeById(int traineeId) {
		Trainee trainee = null;
		try {
			PreparedStatement psmt = connection.prepareStatement("select * from trainee where trainee_id= ?");
			psmt.setInt(1, traineeId);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				trainee = new Trainee(rs.getString(2), rs.getString(3), rs.getDouble(4));
			}

		} catch (SQLException e) {
			throw new DaoException("Error Fetching Trainee", e);
		}
		return trainee;
	}

}
