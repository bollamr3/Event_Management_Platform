package com.eventapp.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import com.eventapp.db.DBConnection;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 6L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        String criteria = request.getParameter("criteria");

        try {
            Connection conn = DBConnection.getConn();
            String sql = "SELECT * FROM events WHERE " + criteria + " LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();

            request.setAttribute("eventList", rs);
            RequestDispatcher rd = request.getRequestDispatcher("displayEvent.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
