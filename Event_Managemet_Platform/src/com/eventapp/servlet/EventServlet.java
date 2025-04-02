package com.eventapp.servlet;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

// This servlet handles GET requests for the /event path
@WebServlet("/event")
public class EventServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html; charset=UTF-8");

        String message = "<h2>Hello! You have reached the Event Page via Servlet.</h2>";
        res.getWriter().write(message);
    }
}
