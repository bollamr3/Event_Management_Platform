
package com.eventapp.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import com.eventapp.db.DBConnection;
import java.io.Serializable;

@WebServlet("/delete")
public class DeleteEventServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 6L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            Connection conn = DBConnection.getConn();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM events WHERE id = ?");
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
            response.sendRedirect("display");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
