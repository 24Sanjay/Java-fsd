package com.Project;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCrossingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the crossing name from the request parameter
            String name = request.getParameter("name");

            // Retrieve the updated details for the crossing
            String crossingStatus = request.getParameter("crossingStatus");
            String personInCharge = request.getParameter("personInCharge");
            String trainSchedules = request.getParameter("trainSchedules");
            String landmark = request.getParameter("landmark");
            String address = request.getParameter("address");

            // Create a new RailwayCrossing object with the updated details
            RailwayCrossing updatedCrossing = new RailwayCrossing();
            updatedCrossing.setName(name);
            updatedCrossing.setCrossing_Status(crossingStatus);
            updatedCrossing.setPersonInCharge(personInCharge);
            updatedCrossing.setTrainSchedule(trainSchedules);
            updatedCrossing.setLandmark(landmark);
            updatedCrossing.setAddress(address);

            // Perform the update operation
            RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
            crossingDAO.updateCrossing(updatedCrossing);

            // Redirect to the admin homepage after the update
            response.sendRedirect("adminHome.jsp");
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            throw new ServletException("An error occurred during the crossing update.", e);
        }
    }
}
