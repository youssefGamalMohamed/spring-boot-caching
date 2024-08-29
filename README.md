# Spring Boot Caching

## Overview
This repository contains a Spring Boot application that demonstrates the integration of caching mechanisms to enhance API performance. The primary goal is to compare the performance results between API endpoints with caching enabled and those without caching.

## Features
- Spring Boot framework
- Spring Data JPA for database operations
- H2 in-memory database for development and testing
- Caching using Spring Cache abstraction
- Performance comparison of API endpoints with and without caching

## Requirements
- Java 11 or higher
- Maven 3.6.0 or higher
- Docker and Docker Compose

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/youssefGamalMohamed/spring-boot-caching.git
   cd spring-boot-caching
   ```

2. **Configure the database and server:**
   The application is preconfigured to use an H2 in-memory database. You can find the configuration in the `application.yaml` file:
   ```yaml
   server:
     port: 9091
     servlet:
       context-path: /social/api/v1

   spring:
     datasource:
       url: jdbc:h2:mem:socialDb
       driverClassName: org.h2.Driver
       username: admin
       password: admin
     h2:
       console:
         enabled: true
     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
       database-platform: org.hibernate.dialect.H2Dialect
     cache:
       type: simple
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## Docker Setup

### Build and Run with Docker Compose

1. **Ensure Docker and Docker Compose are installed:**
   - Docker: [Installation Guide](https://docs.docker.com/get-docker/)
   - Docker Compose: [Installation Guide](https://docs.docker.com/compose/install/)

2. **Build and start the containers:**
   ```bash
   docker-compose up --build
   ```

   This command will start the Spring Boot application and Redis service in containers.

3. **Access the application:**
   - The application will be accessible at: `http://localhost:9091/social/api/v1`

### Example Endpoints
- Create a post: `POST /social/api/v1/posts`
- Retrieve a post by ID: `GET /social/api/v1/posts/{id}`
- Delete a post by ID: `DELETE /social/api/v1/posts/{id}`

### Access H2 Console
- H2 Console: [http://localhost:9091/h2-console](http://localhost:9091/h2-console)
  - **JDBC URL:** `jdbc:h2:mem:socialDb`
  - **Username:** `admin`
  - **Password:** `admin`

## Contributing
1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any questions or suggestions, feel free to open an issue or contact the repository owner.
