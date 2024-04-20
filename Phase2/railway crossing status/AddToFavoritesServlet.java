package com.Project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToFavoritesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String crossingName = request.getParameter("crossingName"); // Assuming the parameter name is "crossingName"
        if (crossingName != null && !crossingName.isEmpty()) {
            // Perform the database operation to add the crossing to favorites
            RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
            crossingDAO.addToFavorites(crossingName); // Implement this method in RailwayCrossingDAO
        }
        // Redirect back to the userHome.jsp page
        response.sendRedirect("userHome.jsp");
    }
}