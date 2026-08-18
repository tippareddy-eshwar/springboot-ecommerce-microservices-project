# Microservices-Based E-Commerce Order Management System

## Project Overview

This project is a distributed E-Commerce application developed using Spring Boot and the Microservices architecture.

The application manages products, orders, inventory, payments, and customer notifications by separating each business functionality into an independent microservice.

The project also implements service discovery, centralized configuration, API Gateway, inter-service communication, asynchronous messaging, fault tolerance, centralized logging, API documentation, and application monitoring.

---

## Project Architecture
```

                            ------------------
                           |      Client      |
                            ------------------
                                     |
                                     |
                           ------------------
                           |    API Gateway   |
                           ------------------
                                     |
                                     |

                           ------------------
                           |   Eureka Server  |
                           ------------------
                                     |
        ----------------------------------------------------------------
        |                      |                     |                 |
        |                      |                     |                 |

------------------     ----------------     ------------------     ------------------
| Product Service|    |  Order Service |    |Inventory Service|    | Payment Service |
------------------    - ---------------      ----------------       ----------------
        |                      |                     |                 |
        |                      |------Feign--------- |                 |
        |                      |------Feign--------------------------- |
        |                      |------Feign--------- |                 |
        |                      |                                       |
        |                      |--------------Kafka--------------------|
        |                                      |
        |                                      |
        |                          ----------------------
        |                          | Notification Service |
        |                           ----------------------
        |                                      |
        ----------------------------------------------------------------
                                     |
                                     |
                           ------------------
                           |      MySQL DB    |
                            ------------------

        ----------------------------------------------------------------
                                     |
                                     |
                            ------------------
                           |   Config Server  |
                            ------------------

        ----------------------------------------------------------------
                                     |
                                     |
                           +------------------+
                           |     ELK Stack     |
                           | Elasticsearch     |
                           | Logstash          |
                           | Kibana            |
                           +------------------+


```


## Microservices Included

### Eureka Server

* Service registration
* Service discovery

### Config Server

* Centralized configuration management

### API Gateway

* Single entry point for all microservices
* Request routing

### Product Service

* Add product
* Update product
* Delete product
* Get product details
* Category management

### Order Service

* Place order
* Get order details
* Delete order

### Inventory Service

* Add stock
* Reduce stock
* Check stock availability

### Payment Service

* Process payments
* Retrieve payment details

### Notification Service

* Consume Kafka messages
* Store notifications
* Simulate email notifications

---

## Technologies Used

* Java
* Spring Boot
* Spring Cloud
* Spring Data JPA
* Hibernate
* MySQL
* Eureka Server
* Spring Cloud Config
* Spring Cloud Gateway
* OpenFeign
* Apache Kafka
* Circuit Breaker (Resilience4j)
* ELK Stack
* Swagger (OpenAPI)
* Spring Boot Actuator
* Maven
* Git
* GitHub

---

## Features Implemented

* Microservices architecture
* Service discovery using Eureka
* Centralized configuration using Config Server
* API Gateway
* Synchronous communication using OpenFeign
* Asynchronous communication using Kafka
* Circuit Breaker implementation
* Global exception handling
* DTO pattern
* Validation using Jakarta Validation
* Centralized logging using ELK Stack
* API documentation using Swagger
* Application monitoring using Spring Boot Actuator

---

## Service Communication

### Synchronous Communication

* Order Service → Product Service
* Order Service → Inventory Service
* Order Service → Payment Service

Implemented using OpenFeign.

### Asynchronous Communication

* Order Service → Notification Service

Implemented using Apache Kafka.

---

## API Documentation

Swagger UI:

[http://localhost:{port}/swagger-ui/index.html](http://localhost:{port}/swagger-ui/index.html)

OpenAPI:

[http://localhost:{port}/v3/api-docs](http://localhost:{port}/v3/api-docs)

---

## Monitoring

Actuator endpoints:

* /actuator/health
* /actuator/info
* /actuator/metrics

---

## Centralized Logging

Implemented using:

* Elasticsearch
* Logstash
* Kibana

---

## Future Improvements

* CI/CD using Jenkins
* Docker
* Frontend integration

---

## Author
Tippareddy Eshwar Reddy

