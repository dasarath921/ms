# User REST API Project

A simple REST API project for managing users using Spring Boot, Spring Data JPA, and MySQL database.

## Prerequisites

- Java 17+
- Maven 3.9.9+
- MySQL Server 5.7 or higher
- MySQL is running on localhost:3306

## Setup Instructions

### 1. Create MySQL Database

Open MySQL command line and run:

```sql
CREATE DATABASE user_db;
USE user_db;
```

### 2. Configure Database Connection

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
```

**Update username and password** if your MySQL credentials are different.

## Project Structure

```
src/main/java/com/example/demo/
├── controller/
│   └── UserController.java      # REST API endpoints
├── model/
│   └── User.java                # User entity model
├── repository/
│   └── UserRepository.java       # Database repository
├── service/
│   └── UserService.java          # Business logic
└── DeployProjectApplication.java # Main application class
```

## Features

- **Create User** - POST /api/users
- **Read All Users** - GET /api/users
- **Read User by ID** - GET /api/users/{id}
- **Read User by Email** - GET /api/users/email/{email}
- **Update User** - PUT /api/users/{id}
- **Delete User** - DELETE /api/users/{id}

## Configuration

- **Server Port**: 2002
- **Database**: MySQL
- **Database Name**: user_db
- **Default Credentials**:
  - Username: root
  - Password: root

## API Endpoints

### 1. Create a New User
```
POST /api/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "address": "123 Main St, City"
}

Response: 201 Created
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "address": "123 Main St, City"
}
```

### 2. Get All Users
```
GET /api/users

Response: 200 OK
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "phone": "1234567890",
    "address": "123 Main St, City"
  }
]
```

### 3. Get User by ID
```
GET /api/users/1

Response: 200 OK
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "address": "123 Main St, City"
}
```

### 4. Get User by Email
```
GET /api/users/email/john@example.com

Response: 200 OK
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "address": "123 Main St, City"
}
```

### 5. Update User
```
PUT /api/users/1
Content-Type: application/json

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "phone": "9876543210",
  "address": "456 New St, City"
}

Response: 200 OK
{
  "id": 1,
  "name": "John Updated",
  "email": "john.updated@example.com",
  "phone": "9876543210",
  "address": "456 New St, City"
}
```

### 6. Delete User
```
DELETE /api/users/1

Response: 204 No Content
```

## Running the Application

1. **Ensure MySQL is running**:
   ```
   mysql -u root -p
   ```

2. **Create the database** (if not already created):
   ```sql
   CREATE DATABASE user_db;
   ```

3. **Build the project**:
   ```
   mvn clean install
   ```

4. **Run the application**:
   ```
   mvn spring-boot:run
   ```
   or
   ```
   java -jar target/DeployProject-0.0.1-SNAPSHOT.jar
   ```

5. **Access the application**:
   - API Base URL: http://localhost:2002/api/users
   - Spring Boot Actuator: http://localhost:2002/actuator (if enabled)

## Testing with cURL

```bash
# Create a user
curl -X POST http://localhost:2002/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com","phone":"1234567890","address":"123 Main St"}'

# Get all users
curl http://localhost:2002/api/users

# Get user by ID
curl http://localhost:2002/api/users/1

# Get user by email
curl http://localhost:2002/api/users/email/john@example.com

# Update user
curl -X PUT http://localhost:2002/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Doe","email":"jane@example.com","phone":"9876543210","address":"456 New St"}'

# Delete user
curl -X DELETE http://localhost:2002/api/users/1
```

## Technologies Used

- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **MySQL 5.7+**
- **MySQL Connector/J 8.0.33**
- **Hibernate ORM**
- **Java 17**
- **Maven**

## Dependencies

- spring-boot-starter-webmvc
- spring-boot-starter-data-jpa
- mysql-connector-java (8.0.33)
- spring-boot-devtools

## Error Handling

- **400 Bad Request** - Duplicate email or invalid input
- **404 Not Found** - User ID or email not found
- **201 Created** - User successfully created
- **204 No Content** - User successfully deleted
- **200 OK** - Successful GET/PUT request

## Notes

- Email field is unique - attempting to create/update with a duplicate email will return 400 Bad Request
- CORS is enabled for all origins
- Hibernate auto-creates/updates the tables (ddl-auto=update)
- Ensure MySQL is running before starting the application

