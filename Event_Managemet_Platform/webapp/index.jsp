<!-- index.jsp -->
<html>
<head><title>Event Manager</title></head>
<body>
    <h1>Welcome to Event Manager</h1>
    <a href="display">View Events</a> | 
    <a href="rsvp.jsp">RSVP</a> | 
    <a href="index.jsp">Add New Event</a>
    <form action="add" method="post">
        <h2>Create Event</h2>
        Name: <input type="text" name="eventName" required><br>
        Location: <input type="text" name="eventPlace" required><br>
        Type:
        <select name="eventType">
            <option>Conference</option>
            <option>Workshop</option>
            <option>Party</option>
            <option>Wedding</option>
        </select><br>
        Date: <input type="date" name="eventDate" required><br>
        Description: <textarea name="description"></textarea><br>
        <input type="submit" value="Create Event">
    </form>
</body>
</html>
