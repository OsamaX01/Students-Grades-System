# Students Grades System

## Overview:
This repository contains a system consisting of four Spring Boot applications and a MySQL database, all containerized and combined using Docker Compose. This system is designed to efficiently handle student data, authentication, analytics, and result presentation for system administrators.

![image](https://user-images.githubusercontent.com/77506711/194639866-12aede41-8878-45de-847b-f388d7c699d6.png)

## Apps Responsibilities:

1. **Enter Data App:**
   - Collects student data from the system admin and stores it in a MySQL database.

2. **Authentication App:**
   - Acts as a backend authentication service, validating admin credentials.

3. **Analytics App:**
   - Works as a backend service that reads students' data from the MySQL database, performs analytics and stores the results in a separate table in the same database.

4. **Show Results App:**
   - Reads results from the MySQL database and presents them to the admin.

## Technological Details:

### Docker:
- The system is containerized using Docker Compose, creating five containers: four for the Spring apps and one for the MySQL database.
- Each Spring App has its Docker file, utilizing a compiled/packaged Java JAR file to speed up the process.
- The Docker Compose file (version 3.8) defines services, and networks, and specifies that all containers will work on a network named "nt2."

### Database Container:
- Utilizes the official MySQL image from Docker Hub, running on port 3306 with the name "mysqldb."
- Implements a health check to ensure the database is ready before dependent containers start.
- Includes a simple volume running the `init.sql` file to initialize the database with tables and initial records.

### Spring Apps Configuration:
- Each Spring app specifies dependencies, connection details, and port information in the environment section of the Docker Compose file.

### Spring Apps:

1. **Authentication App:**
   - Simple web app on port 7070 providing backend services for authentication.
   - Supports GET and POST requests to check admin authentication.

2. **Enter Data App:**
   - Follows MVC/Spring Boot conventions.
   - Uses a form with GET and POST requests to interact with the database.
   - Utilizes Web Flux library for sending requests to the authentication service to validate admin credentials.

3. **Analytics Service:**
   - Similar structure to the Enter Data app.
   - Connects to the database and generates analytics using queries such as AVG, MAX, and MIN.
   - Updates analytics every 2 seconds, responding to new data entries.

4. **Show App:**
   - Accesses the authentication service to validate admin credentials.
   - Reads and displays results from the database on the front end at `localhost/9090/results`.

## Usage:
- Run the system using Docker Compose, which will guide you to the desired app on `localhost/8080`.

Note: Ensure all Spring apps are packaged before executing the Docker Compose command.
