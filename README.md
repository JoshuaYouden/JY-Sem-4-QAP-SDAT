# 🚀 API Documentation

### 🔍 Supported Search APIs

#### **1️⃣ Search Members** (`POST /api/members_search`)

You can search for members based on:

- **Name**
- **Email**
- **Phone Number**
- **Start Date of Membership**

**Example Request Body:**

```json
{
  "memberName": "John Doe",
  "memberEmail": "johndoe@example.com",
  "memberPhoneNumber": "555-1234",
  "memberStartDate": "2025-03-01"
}
```

**Example Response:**

```json
[
  {
    "id": 1,
    "memberName": "John Doe",
    "memberEmail": "johndoe@example.com",
    "memberPhoneNumber": "555-1234",
    "memberStartDate": "2025-03-01"
  }
]
```

#### **2️⃣ Search Tournaments** (`POST /api/tournaments_search`)

You can search for tournaments based on:

- **Start Date**
- **Location**
- **Find all members in a tournament**

**Example Request Body:**

```json
{
  "tournamentStartDate": "2025-06-10",
  "tournamentLocation": "New York"
}
```

**Example Response:**

```json
[
  {
    "id": 1,
    "tournamentLocation": "New York",
    "tournamentStartDate": "2025-06-10",
    "tournamentEndDate": "2025-06-15",
    "participatingMembers": [
      {
        "id": 1,
        "memberName": "John Doe"
      }
    ]
  }
]
```

---

## 🐳 Running the Project with Docker

To make it easy for developers to set up and run the project, **Docker support** has been added.

### **1️⃣ Prerequisites**

- Install **Docker**: [Download Docker](https://www.docker.com/get-started)
- Install **Docker Compose** (if not included in your Docker installation).

### **2️⃣ Build and Run the Project**

1. Clone the repository:

   ```sh
   git clone https://github.com/JoshuaYouden/JY-Sem-4-QAP-SDAT.git
   cd JY-Sem-4-QAP-SDAT-main
   ```

2. **Build and Start the Containers**:

   ```sh
   docker-compose up --build
   ```

3. The Spring Boot application should now be running at:
   - **API Base URL:** `http://localhost:8080/api`
   - **MySQL Database:** Accessible via `localhost:3306`

### **3️⃣ Stopping the Containers**

To stop the running containers, use:

```sh
docker-compose down
```

---

# Thank you for using my project!

#
