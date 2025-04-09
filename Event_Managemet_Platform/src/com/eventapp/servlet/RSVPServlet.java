package com.eventapp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.eventapp.db.DBConnection;

@WebServlet("/rsvp")
public class RSVPServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eventId = request.getParameter("eventId");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("UPDATE events SET attendees = attendees + 1 WHERE id = ?");
            ps.setInt(1, Integer.parseInt(eventId));
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h2>✅ RSVP Successful!</h2>");
            } else {
                out.println("<h2>❌ RSVP Failed. Invalid Event ID.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}