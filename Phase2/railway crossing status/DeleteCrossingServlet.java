package com.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCrossingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the crossing name from the request
            String crossingName = request.getParameter("name");

            if (crossingName != null && !crossingName.isEmpty()) {
                // Perform the delete operation
                RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
                crossingDAO.deleteCrossing(crossingName);
                // Redirect to the admin homepage after the deletion
                response.sendRedirect("adminHome.jsp");
            } else {
                // Handle case where crossingName is empty or null
                throw new ServletException("Crossing name is missing.");
            }
        } catch (Exception e) {
            // Handle exceptions
            throw new ServletException("An error occurred during the crossing deletion.", e);
        }
    }
}
