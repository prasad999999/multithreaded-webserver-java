
---

# 🖧 Java Multithreaded Client-Server System

This project demonstrates a **Java-based multithreaded client-server communication system** implemented using sockets and thread pools.

---

## 📂 Project Structure

```
📦 WebServer
 ┣ 📂 MultiThreaded WebServer
 ┃ ┣ 📜 Server.java
 ┃ ┗ 📜 Client.java
 ┣ 📂 ThreadPool
 ┃ ┗ 📜 Server.java
 ┗ 📜 README.md
```

---

## ⚙️ Overview

### **MultithreadedWebServer**

* The **Server** accepts multiple client connections and spawns a new thread for each.
* The **Client** creates 100 concurrent connections to the server and exchanges simple messages.

### **ThreadPool**

* The **Server** uses a **fixed thread pool (ExecutorService)** for efficient resource management.
* Handles multiple clients concurrently without spawning unlimited threads.

---

## 🏃 How to Run

1. **Compile:**

   ```bash
   javac MultithreadedWebServer/*.java ThreadPool/*.java
   ```
2. **Run a Server (choose one):**

   ```bash
   java MultithreadedWebServer.Server
   ```

   or

   ```bash
   java ThreadPool.Server
   ```
3. **Run the Client (in another terminal):**

   ```bash
   java MultithreadedWebServer.Client
   ```

---

## 🧠 Highlights

* Uses **TCP Sockets** for communication
* Demonstrates **multi-threading** and **thread pooling**
* Supports **concurrent client connections**
* Simple and scalable server design

---

## 🧩 Example Output

**Server:**

```
Server is listening on port 8010
Connection accepted from client /127.0.0.1:50512
```

**Client:**

```
Response from socket is Hello from the server
```

---
