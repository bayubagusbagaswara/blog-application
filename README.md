# Blog Application

* Build REST API's for as simple Blog Application
    * User should able to list, create, update and delete posts
    * User should able to perform pagination and sorting on posts
    * User should able to add, update, delete comments for post
    * User should able to register to Blog App
    * User should able to login to blog App
* Build REST API's for pagination and sorting
* Proper REST API exception or error handling
* Proper REST API Request validation
* Secure REST API's (role based security) - ADMIN, USER
* Use Token based authentication
* Document All REST API's for Consumers
* Deploy Blog App Production

## Technologies

- Java 17
- Spring Framework or Spring Boot
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- Maven
- Intellij IDEA
- Tomcat and embedded server
- Database : PostgreSQL
- REST Client : Postman
- REST API Documentation: Swagger
- Production: AWS

- Harus menggunakan Java version 17

# High Level Requirements for Blog App

1. Posts Management - Create, Read, Update, and Delete Posts. Provide Pagination and Sorting Support
2. Comments Management - Create, Read, Update, and Delete Comments for Blog Post
3. Authentication and Authorization - Register, Login, and Security
4. Category Management - Create, Read, Update, and Delete Category

## Posts Management
Build the REST APIs for Post resource:
1. Create Post REST API
2. Get Single Post REST API
3. Get All Posts REST API
4. Get All Posts REST API with Pagination and Sorting
5. Update Post REST API
6. Delete Post REST API

## Comments Management for Post
Build the REST APIs for Comment resource (one to many mapping):
1. Create Comment REST API - /posts/{post-id}/comments
2. Get Single Comment REST API - /posts/{post-id}/comments/{comment-id}
3. Get All Comments REST API - /posts/{post-id}/comments
4. Update Comment REST API - /posts/{post-id}/comments/{comment-id}
5. Delete Comment REST API - /posts/{post-id}/comments/{comment-id}

## Exceptions Handling and Validations
1. Handle the exceptions and errors and return proper error response to the client
2. Validate the REST API request and send the validation error response to the client

## Securing REST APIs
1. Secure REST APIs using Database Authentication
2. Build Login/Signin REST API
3. Build Register/SignUp REST API
4. Use JWT (Json Web Token) token based Authentication to Secure the REST APIs
5. Implement Role-based security - ADMIN and USER roles

## Category Management
Build the REST APIs for Category resource:

1. Create Category REST API
2. Get Single Category REST API
3. Get All Categories REST API
4. Update Category REST API
5. Delete Category REST API
6. Get Posts By Category REST API

## Versioning REST APIs and Deploying on AWS Cloud
1. Versioning REST APIs using different strategies
2. Deploy Blog App on AWS Cloud

# Selecting Technology Stack for Blog App
- Java Platform: Java 17+
- Java Frameworks: Spring Framework and it's portfolio projects like Spring Boot, Spring Security and Spring Data JPA
- Token Based Authentication: JWT (Json Web Token)
- Build Tool: Maven
- IDE: IntelliJ IDEA
- Server: Tomcat embedded server
- Database: MySQL database
- REST Client: Postman
- Cloud for Deployment: AWS Cloud

# Identity Resources for Blog App
Identity the resources for create REST endpoints
- Post : CRUD REST APIs Pagination and Sorting
- Comment : CRUD REST APIs One to Many mapping Between Post and Comment Resources
- User : Register and Login REST APIs Secure REST APIs using JWT
- Category : CRUD REST APIs

## Pagination Support for Get All Posts REST API

- private List<Post> content;
- private int pageNo;
- private int pageSize;
- private long totalElements;
- private int totalPages;
- private boolean last;