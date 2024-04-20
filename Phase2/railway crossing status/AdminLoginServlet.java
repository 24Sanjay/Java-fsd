package com.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {
    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/railway";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Sanjay@24";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Establish database connection
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Prepare SQL statement to check user credentials
            if (email.equals("qwerty")&&password.equals("virat")) {
            	response.sendRedirect("adminHome.jsp");

            	
            }
            else {
            	request.getRequestDispatcher("adminLogin.jsp").forward(request, 
            	response);
            	}

                    
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        
    }
}
