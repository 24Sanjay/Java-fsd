package com.Project;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/railway";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Sanjay@24";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Establish database connection
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Prepare SQL statement to insert user data into the 'users' table
            String sql = "INSERT INTO users ( email, password) VALUES ( ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);
                
                // Execute the SQL statement to insert user data
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Redirect to login page after successful registration
        response.sendRedirect("userLogin.jsp");
    }
}