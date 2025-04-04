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
