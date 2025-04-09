<%@ page import="java.sql.*, com.eventapp.db.DBConnection" %>
<html>
<head><title>RSVP</title></head>
<body>
<h2>📝 RSVP to an Event</h2>
<%
    Connection conn = DBConnection.getConn();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT id, name, eventDate, eventType FROM events");
%>
<form action="rsvp" method="post">
    <label>Select Event:</label><br>
    <select name="eventId" required>
        <% while (rs.next()) { %>
            <option value="<%= rs.getInt("id") %>">
                <%= rs.getString("name") %> | <%= rs.getString("eventDate") %> | <%= rs.getString("eventType") %>
            </option>
        <% } %>
    </select><br><br>
    <input type="submit" value="RSVP">
</form>
</body>
</html>