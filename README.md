## Bookstore - Spring Boot 3, JPA, Spring Security with JWT, and Docker

### Description

#### This is a sample project that demonstrates how to build a RESTful web service for a bookstore using Spring Boot 3, JPA, Spring Security with JWT, and Docker.

## Prerequisites
* JDK 17 or higher
* Maven 3.8.6 or higher
* PostgreSQL database
* Docker
* Docker compose

## Getting Started
1. #### Clone the repository:

`git clone https://github.com/your-username/bookstore.git`

2. #### Run the Docker containers using Docker Compose:

`docker-compose up`

The application will start at **http://localhost:8080**.

### Usage
You can use any REST client (e.g. Postman, Insomnia) to interact with the API. The following endpoints are available:

**/api/v1/auth/register** (POST): Create a new user account.

**/api/v1/auth/login** (POST): Authenticate a user and generate a JWT token.

**/api/v1/books** (GET): Get all books in the bookstore (requires authentication).

**/api/v1/books/{id}** (GET): Get a book by ID (requires authentication).

**/api/v1/books** (POST): Add a new book to the bookstore (requires authentication).

**/api/v1/orders** (GET): Get all orders (requires authentication).

**/api/v1/orders** (POST): Create a new order (requires authentication).

**/api/v1/orders/{id}** (GET): Get an order by ID (requires authentication).

To access the protected endpoints, include the JWT token in the Authorization header using the Bearer scheme.