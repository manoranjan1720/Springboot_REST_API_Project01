# Spring Boot REST API Project

This project is a simple **Spring Boot REST API** for managing Actor information. It supports complete CRUD operations and is built using Spring Data JPA with an H2 or any relational database.

## 📁 Project Structure

- **Entity Layer**  
  Maps `ActorInfoEntity` to the `REST_ACTORINFO` table in the database.

- **Binding Layer**  
  Contains `ActorData` - a DTO used for data exchange between client and server.

- **Repository Layer**  
  Interface `IActorInfoRepository` extending `JpaRepository` for DB operations.

- **Service Layer**   
  Contains business logic (`IActorInfoMgmtService` and its implementation).

- **Controller Layer**   
  REST controller `ActorOperationsController` exposing various endpoints.

- **Advice Layer**  
  Global exception handling using `@RestControllerAdvice`.

## 🔗 API Endpoints

Base URL: `/actor-api`

| Method | Endpoint               | Description                      |
|--------|------------------------|----------------------------------|
| POST   | `/save`                | Save a new actor                 |
| GET    | `/all`                 | Get all actors                   |
| GET    | `/find/{id}`           | Get actor by ID                  |
| PUT    | `/update`             | Update full actor info           |
| PATCH  | `/rupdate/{id}/{status}` | Update actor's status only    |
| DELETE | `/delete/{id}`         | Delete actor by ID               |

## 📦 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- MySQL (configurable)
- Maven

## ⚙️ How to Run

1. Clone the repository:
   git clone https://github.com/manoranjan1720/Springboot_REST_API_Project01.git
   
2. Open in your IDE (Eclipse/IntelliJ).

3. Ensure database credentials and `application.properties` are properly configured.

4. Run the main application class:
   BootApplication.java

## 📘 Notes

- Custom exception handling is provided via `ActorOperationsAdvice`.
- Uses `BeanUtils` for copying data between entities and DTOs.
- Metadata fields like `createdBy`, `updatedBy`, `creationDate`, etc., are auto-populated.
- Optimistic locking is handled via `@Version`.

## 🙌 Author

**Manoranjan Kumar**  
[GitHub Profile](https://github.com/manoranjan1720)
