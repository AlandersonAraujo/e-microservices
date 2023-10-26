# Microservice Project with Spring Boot

This is a microservice project demonstrating communication between two microservices using RabbitMQ while adhering to clean architecture principles.

## Services

### Customer Service

The Customer service is a REST API that provides a single endpoint for registering a new customer. After registration, a message is sent to a message queue.

Features:

- Integration with Postgres
- Integration with RabbitMQ
- Spring Security (In Progress)
- Memcached (In Progress)

#### Endpoint

- **Endpoint:** `/customer`
- **Method:** `POST`
- **Body:**

```
{ "name":"Alanderson Cavalcante Araujo", "email":"alanderson@email.com" }
```

### Email Service

The Email service is responsible for consuming a message queue via RabbitMQ and sending emails using AWS SES (Simple Email Service). It also stores events in MongoDB.

Features:

- Integration with MongoDB
- Integration with RabbitMQ
- Integration with AWS SES

## Getting Started

To run this project, use Docker Compose:

**Run with Docker Compose:**

```bash
 docker-compose up --build
```

**Note:** In Progress

## Dependencies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [RabbitMQ](https://www.rabbitmq.com/)
- [PostgreSQL](https://www.postgresql.org/)
- [MongoDB](https://www.mongodb.com/)
- [AWS SES](https://aws.amazon.com/ses/)
- [Spring Security](https://spring.io/projects/spring-security)
- [Memcached](https://memcached.org/)

## Usage

1.  Register a customer by making a POST request to the Customer service endpoint.
2.  The Customer service will integrate with Postgres and RabbitMQ.
3.  Email Service will consume the message queue, send an email using AWS SES, and save events in MongoDB.

Feel free to explore and adapt this microservice project for your needs. If you have any questions or need assistance, please don't hesitate to reach out.

**Note:** This project is still under construction.

Happy coding! 👩‍💻👨‍💻
