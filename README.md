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

## Annotations for Exception Handling

- `@ExceptionHandler` - is an annotation used to handle the specific exceptions and sending the custom responses to the client.
- `@ControllerAdvice` - is an annotation, to handle the exceptions globally.

### Development Process
- Create ErrorDetails Class
- Create GlobalExceptionHandler class
- Test using Postman Client


# Java Bean Validation Basics

- We validate a Java Bean with the standard framework - JSR 380, also knows as Bean Validation 2.0.
- Validating user input is a super common requirement in most applications. And the Java Bean Validation has become the de factor standard for handling this kind of logic.
- JSR 380 is a specification of the Java API for bean validation and this ensures that the properties of a bean meet specific criteria, using annotations such as @NotNull, @Min, and @Max
- Hibernate Validator is the reference implementation of the validation API

## Important Bean Validation annotations
- `@NotNull` validates that the annotated property value is not null.
- `@Size` validates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties
- `@Min` validates that the annotated property has a value no smaller than the value attribute
- `@Max` validates that the annotated property has a value no larger than the value attribute
- `@Email` validates that the annotated property is a valid email address
- `@NotEmpty` validates that the property is not null or empty; can be applied to String, Collection, Map or Array values
- `@NotBlank` can be applied only to text values and validates that the property is not null or whitespace

# Validate Create Post and Update Post REST API Request

# Migration and Clean Up
1. Spring boot version 3.0.x and Java 17 or later
2. Change package name from javax to jakarta
3. Change the Hibernate dialect
4. Drop and create new database
5. Insert records in posts and comments table

# Securing REST API with In memory Authentication


# What is JWT
- JSON Web Token (JWT) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object.
- JWT, or JSON Web Tokens (RFC 7519), is a standard that is mostly used for securing REST APIs.
- JWT is best way to communicate securely between client and server
- JWT follows stateless authentication mechanism

## When should you use JSON Web Tokens?
- Authorization
- Information Exchange

## Development Steps
1. Add JWT related Maven dependencies
2. Create JwtAuthenticationEntryPoint
3. Add Jwt properties in application properties file
4. Create JwtTokenProvider - Utility class
5. Create JwtAuthenticationFilter
6. Create JwtAuthResponse DTO
7. Configure JWT in Spring Security
8. Change Login/Signin REST API to Return JWT Token

# Category Management - Requirements
Build the REST APIs for Category resource:
1. Add Category REST API
2. Get Single Category REST API
3. Get All Categories REST API
4. Update Category REST API
5. Delete Category REST API
6. Get Posts By Category REST API

Secure Category REST APIs using Roles
1. Add Category REST API - Secure using ADMIN Role
2. Get Single Category REST API - Provide a Access for All Users
3. Get All Categories REST API - Provide a Access for All Users
4. Update Category REST API - Secure using ADMIN Role
5. Delete Category REST API - Secure using ADMIN Role

# Bagian 21 : Versioning REST APIs
- API versioning is the practice of transparently managing changes to your API
- We will look at 4 ways of versioning a REST API
1. Versioning through URI Path
2. Versioning through query parameters
3. Versioning through custom headers
4. Versioning through content negotiation

