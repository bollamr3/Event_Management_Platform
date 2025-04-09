# Event Management Platform - 7051CEM Coursework

This platform helps users create and manage events like weddings, parties, and conferences.  
Also includes a small machine learning model to guess event type using WEKA.

## Folders
- `src/`: Java files
- `webapp/`: JSP pages
- `dataset/`: Event data
- `docs/`: ERD and notes

## Author
Student Name: RaviTeja Bollam
Module Code: 7051CEM  


Day 1 
-Created project folder structure manually:
-src/ for Java files
-webapp/ for JSP and XML
-docs/, dataset/, .gitignore, and README.md added
-Initialized GitHub repository to track daily progress
-Uploaded initial placeholder files
-Added basic index.jsp and web.xml files
-Created basic servlet EventServlet.java with dummy output
-Set up Eclipse project (initial attempt)


 Day 2 
- Moved index.jsp to correct webapp folder
- Fixed project structure for WAR export
- Set up Tomcat manually with correct JAVA_HOME
- Successfully exported WAR and deployed to localhost

Day 3
- Added HTML form to `index.jsp` for event name and venue
- Created servlet logic to read form data using `doPost()`
- Displayed input data dynamically on response page
- Changed app branding to “EventManager”
- Successfully tested JSP-to-servlet interaction on Tomcat

Day 4 Progress 

Implemented Features:
- Successfully connected the servlet (`EventServlet.java`) to a MySQL database using JDBC.
- Created and configured a `DBConnection.java` helper class for managing database connectivity.
- Modified the servlet to receive form data (Event Name and Venue) from `index.jsp`.
- Inserted submitted event data into the MySQL `events` table in the `event_db` database.
- Displayed a success confirmation message on the webpage after form submission.
-
 Tested:
- `index.jsp` form posts to `/event` via POST method.
- Database successfully receives new rows upon submission.
- Form validation ensures fields are not empty.
- Output page shows event name and venue for confirmation.

- Day 5 Progress

Part A: Core Functionalities
1. **Add Events**
   - Form captures: Name, Location, Type, Date, Description
2. **Display Events**
   - Categorized display (Conference, Workshop, etc.)
3. **RSVP & Attendance**
   - Users can RSVP to events using Event ID
   - Attendee count is updated in the database
4. **Search & Filter**
   - Search events by keyword (type/date/location)
5. **Data Validation**
   - Required field validation (HTML-side)

 Technical:
- MySQL Connector JAR (`mysql-connector-j-9.2.0.jar`) added to `WEB-INF/lib` and referenced in Eclipse build path.
- WAR file re-exported and deployed to Tomcat 9 server (`webapps/EventManagementPlatform.war`).
- Tested on `http://localhost:8080/EventManagementPlatform/index.jsp`.

**Search & Filter Functionality Fully Implemented
File Modified: displayEvent.jsp, SearchServlet.java

**Description:
Added a filter form at the top of displayEvent.jsp with:
Text input for Name
Dropdown for Location
Dropdown for Event Type

On clicking "Search", results are filtered using servlet logic.

**Bug Fixed:
405 error → changed the form method to GET to align with doGet() in SearchServlet.

**SearchServlet.java
Implemented clean, parameterized SQL queries for secure filtering.

Ensured it forwards filtered data (eventList) to displayEvent.jsp.

**Filtering Works Dynamically
Events now show up based on the chosen name, location, or type.

Dropdowns preserve selection after search (UX improvement).


