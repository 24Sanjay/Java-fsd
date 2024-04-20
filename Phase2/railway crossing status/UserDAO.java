package com.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private Connection connection;
	

	
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/railway_crossing_status";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "starcity2535";

    private static final String AUTHENTICATE_USER_QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";
    private static final String REGISTER_USER_QUERY = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

    public User authenticateUser(String email, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(AUTHENTICATE_USER_QUERY)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) 
                {
                    return new User( email, password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registerUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(REGISTER_USER_QUERY)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User getUserByEmail(String email) {
    	try {
    	String query = "SELECT * FROM user_signup WHERE email=?";
    	PreparedStatement statement = connection.prepareStatement(query);
    	statement.setString(1, email);
    	ResultSet resultSet = statement.executeQuery();
    	if (resultSet.next()) {
    	User user = new User();
    	user.setEmail(resultSet.getString("email"));
    	user.setPassword(resultSet.getString("password"));
    	return user;
    	}
    	} catch (SQLException e) {
    	e.printStackTrace();
    	}
    	return null;
    	}

}