package com.eventapp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.eventapp.db.DBConnection;

@WebServlet("/event")
public class EventServlet extends HttpServlet {

    private static final long serialVersionUID = 1L; // Fixes the serialization warning

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from form
        String name = request.getParameter("eventName");
        String venue = request.getParameter("eventPlace");

        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Connect to database and insert event data
            Connection conn = DBConnection.getConn();
            if (conn != null) {
                PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO events (name, location) VALUES (?, ?)"
                );
                stmt.setString(1, name);
                stmt.setString(2, venue);
                stmt.executeUpdate();
                conn.close();

                // Success response
                out.println("<h2>✅ Event Saved Successfully</h2>");
                out.println("<p><strong>Name:</strong> " + name + "</p>");
                out.println("<p><strong>Venue:</strong> " + venue + "</p>");
            } else {
                out.println("<h2>❌ Failed to connect to the database.</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>⚠️ An error occurred while saving the event</h2>");
            e.printStackTrace(out);  // Helpful for debugging
        }
    }
}
