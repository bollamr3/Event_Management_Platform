package com.eventapp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

import com.eventapp.db.DBConnection;

@WebServlet("/event")
public class EventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("eventName");
        String venue = request.getParameter("eventPlace");
        String type = request.getParameter("eventType");
        String date = request.getParameter("eventDate");
        String desc = request.getParameter("description");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO events(name, location, eventType, eventDate, description, attendees) VALUES (?, ?, ?, ?, ?, 0)"
            );
            ps.setString(1, name);
            ps.setString(2, venue);
            ps.setString(3, type);
            ps.setString(4, date);
            ps.setString(5, desc);
            ps.executeUpdate();

            out.println("<h2>Event Added!</h2>");
            out.println("<a href='index.jsp'>Add Another</a>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
