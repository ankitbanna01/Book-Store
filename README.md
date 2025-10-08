# 📚 BookStore Application – Microservices Architecture

### 👨‍💻 Developed by **Ankit Mandloi**

---

## 🧠 Overview
We will build a **BookStore Application** using **Spring Boot**, **Spring Cloud**, and **Docker**.

This project demonstrates how to design, develop, and deploy a distributed **microservices-based architecture** with end-to-end integration between multiple services, event-driven communication, and secure APIs.

---

## 🏗️ BookStore Microservices Architecture

### 🧩 **Modules**

#### 1. 📖 catalog-service  
Provides REST APIs for managing the catalog of products (books).  
**Tech Stack:** Spring Boot, Spring Data JPA, PostgreSQL

---

#### 2. 🛒 order-service  
Manages orders and publishes order events to a message broker for asynchronous communication.  
**Tech Stack:** Spring Boot, Spring Security OAuth2, Keycloak, Spring Data JPA, PostgreSQL, RabbitMQ

---

#### 3. ✉️ notification-service  
Listens to order events from RabbitMQ and sends notifications to users.  
**Tech Stack:** Spring Boot, RabbitMQ

---

#### 4. 🌐 api-gateway  
Acts as a gateway to route requests to internal backend services (catalog-service, order-service).  
**Tech Stack:** Spring Boot, Spring Cloud Gateway

---

#### 5. 🛍️ bookstore-webapp  
Customer-facing web application for browsing books, placing orders, and tracking order details.  
**Tech Stack:** Spring Boot, Spring Security OAuth2, Keycloak, Thymeleaf, Alpine.js, Bootstrap

---

## 🎯 Learning Objectives

✅ Building Spring Boot REST APIs  
✅ Database persistence using Spring Data JPA, PostgreSQL, Flyway  
✅ Event-driven asynchronous communication using RabbitMQ  
✅ Implementing OAuth2 security with Spring Security and Keycloak  
✅ Building API Gateway with Spring Cloud Gateway  
✅ Implementing Resiliency using Resilience4j  
✅ Job Scheduling with ShedLock-based distributed locking  
✅ Inter-service communication using RestClient and HTTP interfaces  
✅ Aggregated Swagger Documentation at API Gateway  
✅ Local setup using Docker, Docker Compose, and Testcontainers  
✅ Testing with JUnit 5, RestAssured, Awaitility, WireMock  
✅ Web frontend using Thymeleaf, Alpine.js, and Bootstrap  
✅ Monitoring using Grafana, Prometheus, Loki, and Tempo  

---

## ⚙️ Local Development Setup

### 🧩 Prerequisites

- Java 21 (Use SDKMAN for version management)  
- Docker Desktop  
- IntelliJ IDEA / STS IDE  
- Taskfile utility  
- Postman or REST Client  

### 💻 Installation Commands

```bash
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk install java 24.0.1-tem
$ sdk install maven
$ brew install go-task
# OR
$ go install github.com/go-task/task/v3/cmd/task@latest

✅ Verify Installation
$ java -version
$ docker info
$ docker compose version
$ task --version

🚀 How to Run the Application Locally
git clone https://github.com/ankitbanna01/bookstore.git
cd bookstore

Start Infrastructure using Docker Compose
task start_infra

Run individual microservices from IDE
ApiGatewayApplication
CatalogServiceApplication
OrderServiceApplication
NotificationServiceApplication
BookstoreWebappApplication
