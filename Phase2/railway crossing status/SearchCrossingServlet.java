package com.Project;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "searchCrossingServlet", urlPatterns = { "/searchCrossing"})
public class SearchCrossingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the search ID from the request
        String searchName = request.getParameter("searchName");

        // Retrieve crossing details by ID from the database
        RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
        RailwayCrossing crossing = crossingDAO.getCrossingByName(searchName);

        // Set the search result in the request attribute
        request.setAttribute("crossing", crossing);

        // Redirect to the appropriate page based on user role
        String role = (String) request.getSession().getAttribute("role");
        if (role != null && role.equals("admin")) {
            request.getRequestDispatcher("adminHome.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("userHome.jsp").forward(request, response);
        }
    }
}