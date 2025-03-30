# ✈️ Flight Route Finder API

This is a **Spring Boot REST API** that helps users (like Alice 😊) explore all possible flight routes between two cities. It returns all valid paths, sorted by price in ascending order, with optional filters such as maximum number of allowed flights (layovers).

⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻⸻

### 📦 Features

• 🔍 Find all possible routes between two cities

• 📈 Routes sorted by total price

• 🔄 Supports direct and multi-leg flights

• ✂️ Optional maxTransfers parameter to limit the number of flights

• 🧠 Internal pathfinding algorithm (DFS) with custom sorting (Merge Sort)

• 🔧 Easy to test via .http or Postman