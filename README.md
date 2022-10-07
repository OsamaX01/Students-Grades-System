# Students-Grades-System

## Overview
Students’ system is a system consisting of 4 spring boot apps and one database containerized and combined with docker compose.

### Apps Responsibilities:
1-	Enter Data app: an app responsible of getting students data from the system admin and store it in a MySQL database.

2-	Authentication app: this app works as a backend authentication service which validates admin credentials.

3-	Analytics app: this app works as a backend app service that reads students data from the MySQL database and stores analytics information’s on another table in the same database.

4-	Show Results app: an app responsible of reading the results from the MySQL database and show it to admin.

![image](https://user-images.githubusercontent.com/77506711/194639866-12aede41-8878-45de-847b-f388d7c699d6.png)
