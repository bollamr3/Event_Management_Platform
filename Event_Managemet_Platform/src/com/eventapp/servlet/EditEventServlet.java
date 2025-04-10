// EditEventServlet.java
package com.eventapp.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import com.eventapp.db.DBConnection;
import java.io.Serializable;

@WebServlet("/edit")
public class EditEventServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 4L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("eventName");
        String location = request.getParameter("eventPlace");
        String type = request.getParameter("eventType");
        String date = request.getParameter("eventDate");
        String description = request.getParameter("description");

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE events SET name=?, location=?, eventType=?, eventDate=?, description=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, type);
            ps.setString(4, date);
            ps.setString(5, description);
            ps.setInt(6, Integer.parseInt(id));

            ps.executeUpdate();
            response.sendRedirect("display");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}