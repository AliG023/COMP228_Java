package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public boolean userExists(String fullName) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		List<User> users = new ArrayList<>();

		try {
			connection = Database.getDBConnection();
			connection.setAutoCommit(false);
			String query = "SELECT id, fullName, currentAddress, contactNumber, emailAddress, highestEducation, gender, dateAvailable, desiredPosition, desiredSalary, areYouLegal, relativesWorking, ifYes FROM user WHERE username = ?";
			statement = connection.prepareStatement(query);
			int counter = 1;
			statement.setString(counter++, fullName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setfullName(resultSet.getString(2));
				user.setcurrentAddress(resultSet.getString(3));
				user.setContactNumber(resultSet.getInt(4));
				user.setEmailAddress(resultSet.getString(5));
				user.setHighestEducation(resultSet.getString(6));
				user.setGender(resultSet.getString(7));
				user.setDateAvailable(resultSet.getString(8));
				user.setDesiredPosition(resultSet.getString(9));
				user.setDesiredSalary(resultSet.getInt(10));
				user.setAreYouLegal(resultSet.getString(11));
				user.setRelativesWorking(resultSet.getString(12));
				user.setIfYes(resultSet.getString(13));
				users.add(user);
			}

			return users.isEmpty() ? false : true;
		} catch (SQLException exception) {
			// logger.log(Level.SEVERE, exception.getMessage());
		} finally {
			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return users.isEmpty() ? false : true;
	}

	public int saveUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getDBConnection();
			connection.setAutoCommit(false);
			String query = "INSERT INTO user(fullName, currentAddress, contactNumber, emailAddress, highestEducation, gender, dateAvailable, desiredPosition, desiredSalary, areYouLegal, relativesWorking, ifYes) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int counter = 1;
			statement.setString(counter++, user.getfullName());
			statement.setString(counter++, user.getcurrentAddress());
			statement.setInt(counter++, user.getContactNumber());
			statement.setString(counter++, user.getEmailAddress());
			statement.setString(counter++, user.getHighestEducation());
			statement.setString(counter++, user.getGender());
			statement.setString(counter++, user.getDateAvailable());
			statement.setString(counter++, user.getDesiredPosition());
			statement.setInt(counter++, user.getDesiredSalary());
			statement.setString(counter++, user.getAreYouLegal());
			statement.setString(counter++, user.getRelativesWorking());
			statement.setString(counter++, user.getIfYes());
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException exception) {
			// logger.log(Level.SEVERE, exception.getMessage());
			if (null != connection) {
				connection.rollback();
			}
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}

			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return 0;
	}

}