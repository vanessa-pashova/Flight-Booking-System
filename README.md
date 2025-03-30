# ✈️ Flight Route Finder API

This is a **Spring Boot REST API** that helps users (like Alice 😊) explore all possible flight routes between two cities. It returns all valid paths, sorted by price in ascending order, with optional filters such as maximum number of allowed flights (layovers).

⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻

### ⚙️ Technologies Used

- **Java 21**
- **Spring Boot 3.4**
- **Spring Web (REST)**
- **Lombok** – for reducing boilerplate (getters/setters)
- **Maven** – project management
- **HTTP Client in IntelliJ** – for testing `.http` files

⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻

### 📦 Features

• 🔍 Find all possible routes between two cities

• 📈 Routes sorted by total price

• 🔄 Supports direct and multi-leg flights

• ✂️ Optional maxTransfers parameter to limit the number of flights

• 🧠 Internal pathfinding algorithm (DFS) with custom sorting (Merge Sort)

• 🔧 Easy to test via .http or Postman