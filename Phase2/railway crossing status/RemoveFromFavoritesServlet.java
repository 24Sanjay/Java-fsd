package com.Project;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "removeFromFavoritesServlet", urlPatterns = { "/removeFromFavorites"})
public class RemoveFromFavoritesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String crossingName = request.getParameter("crossingName"); // Assuming the parameter name is "crossingName"
        if (crossingName != null && !crossingName.isEmpty()) {
            // Perform the database operation to remove the crossing from favorites
            RailwayCrossingDAO crossingDAO = new RailwayCrossingDAO();
            crossingDAO.removeFromFavorites(crossingName); // Implement this method in RailwayCrossingDAO
        }
        // Redirect back to the userHome.jsp page
        response.sendRedirect("userHome.jsp");
    }
}
