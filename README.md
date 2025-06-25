# Spring Boot Caching

## Overview
This repository contains a Spring Boot application that demonstrates the integration of caching mechanisms using Redis to enhance API performance. The primary goal is to compare the performance results between API endpoints with caching enabled and those without caching.

## Features
- Spring Boot framework (3.2+)
- Spring Data JPA for database operations
- H2 in-memory database for development and testing
- Redis caching using Spring Cache abstraction
- Dockerized setup for both the application and Redis
- Performance comparison of API endpoints with and without caching

## Requirements
- Java 17 or higher
- Maven 3.6.0 or higher
- Docker and Docker Compose

## Project Structure

```
spring-boot-caching-app/
│
├── src/
├── pom.xml
├── Dockerfile
├── docker-compose.yml
└── README.md
```

## Setup

### 1. Clone the repository
```bash
git clone https://github.com/youssefGamalMohamed/spring-boot-caching.git
cd spring-boot-caching-app
```

### 2. Build and Run with Docker Compose

Make sure Docker and Docker Compose are installed:

- [Docker Installation Guide](https://docs.docker.com/get-docker/)
- [Docker Compose Installation Guide](https://docs.docker.com/compose/install/)

Then run:
```bash
docker-compose up --build
```

This command will build the Spring Boot application and start both the app and Redis containers.

### 3. Access the application

- API Base URL: [http://localhost:9091/social/api/v1](http://localhost:9091/social/api/v1)
- H2 Console: [http://localhost:9091/h2-console](http://localhost:9091/h2-console)
  - **JDBC URL:** `jdbc:h2:mem:socialDb`
  - **Username:** `admin`
  - **Password:** `admin`

## Example Endpoints

- Create a post: `POST /social/api/v1/posts`
- Retrieve a post by ID: `GET /social/api/v1/posts/{id}`
- Delete a post by ID: `DELETE /social/api/v1/posts/{id}`

## Configuration

The application is preconfigured to use an H2 in-memory database and Redis for caching.  
Key configuration is in `application.yaml`:

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
  data:
    redis:
      host: ${REDIS_HOST:localhost}
      port: ${REDIS_PORT:6379}
  cache:
    type: redis
```

Redis connection is configured via environment variables in `docker-compose.yml`:
- `REDIS_HOST=redis`
- `REDIS_PORT=6379`

## Stopping the Application

```bash
docker-compose down
```

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
