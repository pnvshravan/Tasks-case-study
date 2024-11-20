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

### Note:
+ Not implemented a unit test for a critical function.

