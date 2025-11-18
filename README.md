# 📌 OnlineQuizApp – Online Quiz Application

A Spring Boot-based web application to create, take, and manage online quizzes.  
This mini-project demonstrates Spring Boot, Spring Data JPA, MySQL, Thymeleaf and the MVC design pattern — ideal for educators, trainers, or self-learners.

🚀 Features
✅ User Authentication — register and login for instructors and students.  
✅ Dashboard — snapshot of total quizzes, active attempts, recent results.  
✅ Quiz Management — create, edit, delete quizzes and question banks.  
✅ Multiple Question Types — multiple-choice, true/false, short answer.  
✅ Timed Attempts & Auto-Scoring — start timed quizzes and get automatic scoring.  
✅ Results & Analytics — per-student results and quiz analytics.  
✅ Role-based Access — separate flows/permissions for admin/teacher/student.  
✅ Session Handling — only authenticated users can access protected pages.

🛠 Tech Stack
Technology    | Description
------------- | -----------
Java 17+      | Core programming language
Spring Boot 3 | Backend framework (MVC)
Spring Data JPA | ORM for database operations
MySQL         | Relational database (development/production)
Thymeleaf     | Server-side template engine for UI
Lombok        | Reduce boilerplate (entities/DTOs)
Maven         | Build and dependency management

📂 Project Structure
OnlineQuizApp
│── src/main/java/com/sumitkumarmahato/onlinequizapp
│   ├── controller    # Handles HTTP requests
│   ├── dto           # Data Transfer Objects
│   ├── entity        # JPA entities (User, Quiz, Question, Attempt, Result)
│   ├── repository    # Spring Data JPA repositories
│   ├── service       # Business logic
│   └── config        # Security and application configuration
│── src/main/resources
│   ├── templates     # Thymeleaf HTML pages
│   ├── static        # CSS, JS, images
│   └── application.properties
└── pom.xml

⚙ Setup Instructions

1️⃣ Clone the repository
```bash
git clone https://github.com/SumitKumarMahato/OnlineQuizApp.git
cd OnlineQuizApp
```

2️⃣ Configure MySQL Database
Start MySQL and create a database:

```sql
CREATE DATABASE onlinequiz;
```

Update credentials in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/onlinequiz
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

(Adjust values to match your local DB user/password.)

3️⃣ Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

Alternatively, build a jar and run:
```bash
mvn clean package
java -jar target/onlinequizapp-0.0.1-SNAPSHOT.jar
```

4️⃣ Access the Application
Open in browser: http://localhost:8080/

📌 Usage Flow (common endpoints)
1️⃣ Register a user → /register  
2️⃣ Login → /login or /  
3️⃣ View Dashboard → /dashboard  
4️⃣ Create a Quiz → /quizzes/new  
5️⃣ List Quizzes → /quizzes  
6️⃣ Start Quiz → /quizzes/{id}/start  
7️⃣ Submit Answers → /quizzes/{id}/submit  
8️⃣ View Results → /results or /quizzes/{id}/results  
9️⃣ Logout → /logout

🚧 Future Enhancements
🔒 Password hashing (BCrypt) and stronger auth flows (OAuth2).  
📩 Email notifications for registration, results, and reminders.  
🌐 REST API endpoints for external clients (mobile apps, SPA).  
📊 Advanced analytics and export (CSV/PDF).  
⚡ Real-time quizzes (WebSockets) for live proctoring and competitions.  
🧪 Add automated tests (unit + integration) for core flows.

👨‍💻 Author
Sumit Kumar Mahato  
📧 Email: sumitkumar.mahato982@gmail.com  
🔗 LinkedIn: https://www.linkedin.com/in/sumitmahato01/

---

If you want, I can:
- Inspect your repository and replace the placeholders (package name, exact endpoints, database name) with values taken directly from the code.
- Add example screenshots, sample data seed commands, or a Postman collection for the API.
Tell me which of these you'd like next and I'll update the README accordingly.
