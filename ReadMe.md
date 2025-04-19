# 🍕 Pizza Ordering Backend

A Spring Boot-based backend system for a pizza ordering application. This project handles the core backend logic such as pizza item management, order placement, user registration, and order tracking using a PostgreSQL database.

---

## 🚀 Tech Stack

- **Backend Framework:** Spring Boot
- **Language:** Java
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA
- **Build Tool:** Maven or Gradle
- **Architecture:** RESTful API

---

## 📁 Project Structure

```
pizza-ordering-backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/pizza/
│   │   │   ├── controller/        # REST Controllers
│   │   │   ├── model/             # Entity Classes
│   │   │   ├── repository/        # JPA Repositories
│   │   │   ├── service/           # Business Logic
│   │   │   └── PizzaApplication.java  # Main Application
│   │   └── resources/
│   │       ├── application.properties # DB config
│   │       └── data.sql / schema.sql # Initial setup (optional)
├── pom.xml / build.gradle
└── README.md
```

---

## 🧠 Features

- ✅ User Registration and Management
- 🍕 Pizza Menu Management (CRUD)
- 🛒 Place Orders with Pizza Selection
- 📋 View Order History by User
- 🧾 Admin Access to All Orders and Pizzas
- 🗂️ RESTful API Design
- 🌐 CORS Configured (if connected to frontend)

---

## 🔌 Database Configuration (PostgreSQL)

Update the following in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pizza_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🔑 API Endpoints Overview

### 👤 User
| Method | Endpoint         | Description           |
|--------|------------------|-----------------------|
| POST   | `/api/users`     | Register new user     |
| GET    | `/api/users/{id}`| Get user details      |

### 🍕 Pizza
| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/pizzas`    | Get all available pizzas |
| POST   | `/api/pizzas`    | Add new pizza (admin)    |
| PUT    | `/api/pizzas/{id}`| Update pizza (admin)    |
| DELETE | `/api/pizzas/{id}`| Delete pizza (admin)    |

### 📦 Orders
| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| POST   | `/api/orders`          | Place a new order         |
| GET    | `/api/orders/{userId}` | Get orders for a user     |
| GET    | `/api/orders`          | Get all orders (admin)    |

---

## ▶️ Running the Application

Make sure PostgreSQL is running and configured. Then run:

```bash
# If using Maven
mvn clean install
mvn spring-boot:run

# If using Gradle
./gradlew build
./gradlew bootRun
```

---

## 🧪 Testing API

Use Postman, Insomnia, or any REST client to test endpoints.

- Content-Type: `application/json`
- Base URL: `http://localhost:8080`

Example payload for placing an order:

```json
{
  "userId": 1,
  "pizzaIds": [1, 3, 5]
}
```

---

## 📌 Future Enhancements

- JWT-based Authentication
- Order Status Tracking (Pending, Delivered, Cancelled)
- Payment Integration
- Role-based Access Control (Admin vs User)
- Dockerization for Deployment

---

## 📧 Contact

For any queries or collaboration:  
**Gondu Venkatesh**  
📧 venkatesh@example.com  _(replace with your actual email)_

---

## 📄 License

This project is licensed under the MIT License.

---

Made with ❤️ using Java + Spring Boot
