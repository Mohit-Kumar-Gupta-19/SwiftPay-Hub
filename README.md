**💳 SwiftPay-Hub
🚀 A Modern Banking Web Application using Spring Boot & MySQL**

**🌟 Overview**

SwiftPay-Hub is a secure, user-friendly banking web application built using Spring Boot, Thymeleaf, and MySQL.
It allows users to register, login, deposit money, withdraw funds, view balance, track transactions, and submit feedback & contact requests — all through a clean and modern UI.

**✨ Key Features**

✅ Secure User Authentication (Login / Register / Reset Password)
✅ Live Balance Display
✅ Deposit & Withdraw Money
✅ Transaction History
✅ Feedback & Contact Support
✅ Clean MVC Architecture
✅ Responsive & Modern UI

**🛠️ Tech Stack**
Layer	Technology
Backend	Spring Boot (Java 17)
Frontend	Thymeleaf + HTML5 + CSS3
Database	MySQL
Security	Password Hashing
Build Tool	Maven
IDE	VS Code
📂 Project Structure
SwiftPayHub
│
├── src/main/java/com/swiftpayhub
│   ├── controller
│   │   ├── AuthController.java
│   │   ├── BankController.java
│   │   └── SupportController.java
│   │
│   ├── service
│   │   └── BankService.java
│   │
│   ├── db
│   │   └── DBConnection.java
│   │
│   ├── util
│   │   └── PasswordUtil.java
│   │
│   └── SwiftPayHubApplication.java
│
├── src/main/resources
│   ├── templates
│   │   ├── login.html
│   │   ├── dashboard.html
│   │   ├── transactions.html
│   │   ├── feedback.html
│   │   └── contact.html
│   │
│   ├── static
│   │   └── style.css
│   │
│   └── application.properties
│
└── README.md

**Page	Preview**
🔐 Login Page	
🏠 Dashboard	
💰 Deposit Money	
💸 Withdraw Money	
📊 Transactions	
⭐ Feedback	

**⚙️ Database Schema (MySQL)**
👤 Users
user_id (PK)
name
email
password

💳 Accounts
account_id (PK)
user_id (FK)
balance

🔄 Transactions
tx_id (PK)
account_id (FK)
type
amount
tx_time

🚀 How to Run the Project
# Clone repository
git clone https://github.com/Mohit-Kumar-Gupta-19/SwiftPay-Hub

# Open project
cd SwiftPayHub

# Run application
mvn spring-boot:run


➡ Open browser:
http://localhost:8080

🔮 Future Enhancements

🔹 Session-based Login
🔹 Spring Security Integration
🔹 Role-based Access
🔹 REST APIs
🔹 Deployment on AWS / Render

👨‍💻 Author

Mohit Kumar Gupta
🎓 B.Tech CSE
💼 Java | Spring Boot | MySQL | JDBC

⭐ If you like this project, don’t forget to star the repo!


