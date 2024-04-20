package com.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCrossingServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
// Retrieve the form data from the request
String name = request.getParameter("name");
String address = request.getParameter("address");
String landmark = request.getParameter("landmark");
String trainSchedules = request.getParameter("trainSchedule");
String personInCharge = request.getParameter("personInCharge");
String status = request.getParameter("crossing_status");
// Create a new RailwayCrossing object with the form data
RailwayCrossing crossing = new RailwayCrossing();
crossing.setName(name);
crossing.setAddress(address);
crossing.setLandmark(landmark);
crossing.setTrainSchedule(trainSchedules);
crossing.setPersonInCharge(personInCharge);
crossing.setCrossing_Status(status);
// Save the new crossing to the database
RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
crossingDAO.addCrossing(crossing);
// Redirect to the admin homepage after adding the crossing
response.sendRedirect("adminHome.jsp");
}
}