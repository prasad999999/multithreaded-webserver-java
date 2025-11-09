
---

# 🖧 Java Client-Server Communication

A simple **multi-threaded socket communication** project in Java.

## 📂 Files

* `Server.java` – Listens on port **8010**, accepts client connections, and sends `"Hello from the server"`.
* `Client.java` – Creates **100 threads**, connects to the server, sends a message, and prints the response.

## ⚙️ How to Run

1. **Compile:**

   ```bash
   javac Server.java Client.java
   ```
2. **Run Server:**

   ```bash
   java Server
   ```
3. **Run Client (in another terminal):**

   ```bash
   java Client
   ```

## 🧩 Example Output

**Server:**

```
Server is listening on port 8010
Connection accepted from client /127.0.0.1:51234
```

**Client:**

```
Response from socket is Hello from the server
```

## 🧠 Highlights

* Uses **Socket** and **ServerSocket**
* Supports **multi-threading** on both client and server sides
* Demonstrates **basic TCP communication**

---

