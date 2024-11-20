# Tasks-case-study
### Technical Specifications
+ Java with Spring Boot,
+ Spring Data JPA with Hibernate,
+ Spring Web,
+ Lombok,
+ Used H2 in-memory database.

### Implemented API endpoints:

 - GET /tasks: Retrieve all tasks

 - GET /tasks/{id}: Retrieve a specific task by ID

 - POST /tasks: Create a new task

 - PUT /tasks/{id}: Update an existing task

 - DELETE /tasks/{id}: Delete a task

 - PATCH /tasks/{id}/complete: Mark a task as complete

**Each task has the following properties:**
 - id (unique identifier)

 - title (string)

 - description (string)

 - due_date (date)

 - status (enum: "pending", "in_progress", "completed")

 - created_at (timestamp)

 - updated_at (timestamp)

### Steps to run the app:
1. Clone this repo to your local machine.
2. Use **Intellij IDEA Community Edition**(tested with this) IDE.
3. Unzip and open this project in the IDE mentioned.
4. Make sure you are connected to Internet, to download the Maven dependencies required for this project.
5. After indexing and dependencies have been downloaded, if any pop up comes up to install any plugins to run this project, do install them, i.e, for this project - **Lombox** is the external plugin.
6. Look under the project structure to the left, and under /tasks/src/main/java/com.maverick.tasks/ - run/build the **TasksApplication**.java file.
7. After step-6, the app will start running at **localhost:8080** port and access this port on your browser or a API client like **Postman**(tested with this).
8. Now one by one, test the endpoints for functioning of the API. 


**Links:**
[Demo video](https://drive.google.com/file/d/1TO16BI4N6GbkmrZ4QoFYQmAFrXkAAL0T/view?usp=sharing)


### Note:
+ Not implemented a unit test for a critical function.


