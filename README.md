📓 Journal App

A Spring Boot REST API for managing personal journal entries with secure authentication and role-based authorization.

This application allows users to create and manage their journal entries while administrators can manage all users in the system.

🚀 Features

User Registration

Secure Authentication using Spring Security

Role Based Access Control (USER / ADMIN)

Create, Read, Update and Delete Journal Entries

MongoDB database integration

Password encryption using BCrypt

RESTful API architecture

Admin APIs for managing users

Custom server configuration

🛠 Tech Stack

Java 17

Spring Boot

Spring Security

MongoDB Atlas

Maven

REST APIs

Postman (for API testing)

📂 Project Structure
journalApp
│
├── controller
│   ├── UserController
│   ├── AdminController
│   └── JournalEntryController
│
├── service
│   ├── UserService
│   ├── JournalEntryService
│   └── UserDetailServiceImpl
│
├── repository
│   ├── UserRepository
│   └── JournalEntryRepository
│
├── entity
│   ├── User
│   └── JournalEntry
│
├── config
│   └── SpringSecurity
│
└── resources
    └── application.yml
    ⚙️ Configuration

application.yml

spring:
  data:
    mongodb:
      uri: mongodb+srv://<username>:<password>@cluster.mongodb.net/journaldb
      database: journaldb
      auto-index-creation: true

server:
  port: 8081
  servlet:
    context-path: /journal
    🔐 Security

This project uses Spring Security with Basic Authentication.

Roles
Role	Access
USER	Manage personal journal entries
ADMIN	Access all users and manage system

Example security configuration:

.antMatchers("/admin/**").hasRole("ADMIN")
.antMatchers("/public/**").permitAll()
.anyRequest().authenticated()
📡 API Endpoints
Public APIs
Method	Endpoint	Description
POST	/public/create-user	Register new user
User APIs
Method	Endpoint	Description
GET	/user	Get logged in user
PUT	/user	Update user
DELETE	/user	Delete user
Journal APIs
Method	Endpoint	Description
GET	/journal	Get all journal entries
POST	/journal	Create journal entry
GET	/journal/id/{id}	Get journal entry by ID
DELETE	/journal/id/{id}	Delete journal entry
PUT	/journal/id/{id}	Update journal entry
Admin APIs
Method	Endpoint	Description
GET	/admin/all-users	Get all users
POST	/admin/create-admin-user	Create admin user
🧪 Testing APIs

You can test APIs using Postman.

Example request:

GET http://localhost:8081/journal/admin/all-users

Authorization:

Basic Auth
username: admin
password: password
🏃 Running the Project
1️⃣ Clone Repository
git clone https://github.com/your-username/journal-app.git
2️⃣ Navigate to Project
cd journalApp
3️⃣ Build Project
mvn clean package
4️⃣ Run Application
mvn spring-boot:run
