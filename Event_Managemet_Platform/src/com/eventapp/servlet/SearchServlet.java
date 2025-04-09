package com.eventapp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.eventapp.db.DBConnection;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>🔍 Search Results</h2>");

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM events WHERE eventType LIKE ? OR location LIKE ? OR eventDate LIKE ?"
            );
            String likeQuery = "%" + keyword + "%";
            ps.setString(1, likeQuery);
            ps.setString(2, likeQuery);
            ps.setString(3, likeQuery);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                out.println("<li><strong>" + rs.getString("name") + "</strong> | " +
                    rs.getString("eventDate") + " | " + rs.getString("location") + "<br>" +
                    rs.getString("description") + " | Type: " + rs.getString("eventType") +
                    " | Attendees: " + rs.getInt("attendees") + "</li><br>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}