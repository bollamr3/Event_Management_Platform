<%@ page import="java.sql.*" %>
<%@ page import="com.eventapp.db.DBConnection" %>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        padding: 8px;
        border: 1px solid black;
        text-align: left;
    }
</style>

<!-- Search Form -->
<form method="get" action="search">
    <label for="criteria">Search By:</label>
    <select name="criteria">
        <option value="name">Name</option>
        <option value="location">Location</option>
        <option value="eventType">Type</option>
        <option value="eventDate">Date</option>
    </select>
    <input type="text" name="search" placeholder="Enter keyword..." required>
    <input type="submit" value="Search">
</form>
<br>

<!-- Display Events Table -->
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Location</th>
        <th>Type</th>
        <th>Date</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("eventList");
        if (rs != null && rs.next()) {
            do {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("location") %></td>
        <td><%= rs.getString("eventType") %></td>
        <td><%= rs.getDate("eventDate") %></td>
        <td><%= rs.getString("description") %></td>
        <td>
            <a href="editEvent.jsp?id=<%= rs.getInt("id") %>">Edit</a> |
            <a href="rsvp.jsp?id=<%= rs.getInt("id") %>">RSVP</a> |
            <a href="delete?id=<%= rs.getInt("id") %>" onclick="return confirm('Are you sure you want to delete this event?');">Delete</a>
        </td>
    </tr>
    <%
            } while (rs.next());
        } else {
    %>
    <tr><td colspan="7">No events found.</td></tr>
    <% } %>
</table>
