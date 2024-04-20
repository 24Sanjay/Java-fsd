package com.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RailwayCrossingDAO {

	
	private Connection connection;
    public RailwayCrossingDAO() 
    {
     // Initialize the database connection
      connection = DatabaseConnection.getConnection();
    }
     // Fetch all values from the database
    public List<RailwayCrossing> getAllCrossings() {
        List<RailwayCrossing> crossings = new ArrayList<>();
        try {
            String query = "SELECT * FROM railway_crossings";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RailwayCrossing crossing = new RailwayCrossing();
                crossing.setName(resultSet.getString("name"));
                crossing.setCrossing_Status(resultSet.getString("crossing_status"));
                crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
                crossing.setTrainSchedule(resultSet.getString("train_schedule"));
                crossing.setLandmark(resultSet.getString("landmark"));
                crossing.setAddress(resultSet.getString("address"));
                crossings.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crossings;
    }

    // Add a railway crossing to the database
    public void addCrossing(RailwayCrossing crossing) {
        try {
            String query = "INSERT INTO railway_crossings (name, crossing_status, person_in_charge, train_schedules, landmark, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossing.getName());
            statement.setString(2, crossing.getCrossing_Status());
            statement.setString(3, crossing.getPersonInCharge());
            statement.setString(4, crossing.getTrainSchedule());
            statement.setString(5, crossing.getLandmark());
            statement.setString(6, crossing.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCrossing(RailwayCrossing crossing) {
        try {
            String query = "UPDATE railway_crossings SET crossing_status=?, person_in_charge=?, train_schedules=?, landmark=?, address=? WHERE name=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossing.getName());
            statement.setString(2, crossing.getCrossing_Status());
            statement.setString(3, crossing.getPersonInCharge());
            statement.setString(4, crossing.getTrainSchedule());
            statement.setString(5, crossing.getLandmark());
            statement.setString(6, crossing.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a railway crossing from the database
    public void deleteCrossing(String crossingName) {
        try {
            String query = "DELETE FROM railway_crossings WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossingName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get favorite railway crossings from the database
    public List<RailwayCrossing> getFavoriteCrossings() {
        List<RailwayCrossing> favoriteCrossings = new ArrayList<>();
        try {
            String query = "SELECT * FROM railway_crossings rc JOIN favorite_crossings fc ON rc.name = fc.railway_crossing_name";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RailwayCrossing crossing = new RailwayCrossing();
                crossing.setName(resultSet.getString("name"));
                crossing.setCrossing_Status(resultSet.getString("crossing_status"));
                crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
                crossing.setTrainSchedule(resultSet.getString("train_schedules"));
                crossing.setLandmark(resultSet.getString("landmark"));
                crossing.setAddress(resultSet.getString("address"));
                favoriteCrossings.add(crossing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoriteCrossings;
    }
    // Add a railway crossing to favorites
    public void addToFavorites(String crossingName) {
        try {
            String query = "INSERT INTO favorite_crossings (railway_crossing_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossingName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a railway crossing from favorites
    public void removeFromFavorites(String crossingName) {
        try {
            String query = "DELETE FROM favorite_crossings WHERE railway_crossing_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossingName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public RailwayCrossing getCrossingByName(String crossingName) {
        RailwayCrossing crossing = null;
        try {
            String query = "SELECT * FROM railway_crossings WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, crossingName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                crossing = new RailwayCrossing();
                crossing.setName(resultSet.getString("name"));
                crossing.setCrossing_Status(resultSet.getString("crossing_status"));
                crossing.setPersonInCharge(resultSet.getString("person_in_charge"));
                crossing.setTrainSchedule(resultSet.getString("train_schedule"));
                crossing.setLandmark(resultSet.getString("landmark"));
                crossing.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crossing;
    }
}