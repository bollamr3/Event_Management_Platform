// DisplayEventsServlet.java
package com.eventapp.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import com.eventapp.db.DBConnection;
import java.io.Serializable;

@WebServlet("/display")
public class DisplayEventsServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 5L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM events");
            ResultSet rs = ps.executeQuery();
            request.setAttribute("eventList", rs);
            RequestDispatcher rd = request.getRequestDispatcher("displayEvent.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}