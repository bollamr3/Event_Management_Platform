package com.eventapp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/event")
public class EventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eventTitle = request.getParameter("eventName");
        String eventVenue = request.getParameter("eventPlace");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html><head><title>EventManager</title></head><body>");
        writer.println("<h2>EventManager - Received Details</h2>");
        writer.println("<p><b>Event:</b> " + eventTitle + "</p>");
        writer.println("<p><b>Venue:</b> " + eventVenue + "</p>");
        writer.println("</body></html>");
    }
}
