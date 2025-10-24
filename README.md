# 🎓 Student Management System (Java + JDBC + MySQL)

A console-based CRUD application to manage student records.

## 🛠️ Technologies Used
- Java (JDK 17)
- JDBC
- MySQL
- DAO Design Pattern

## ✨ Features
- Add new students
- View student records by rollNo
- View all student records
- Update student records
- Delete student records
- Menu-driven console interface

## 📦 How to Run
1. Create MySQL database:
   ```sql
   CREATE DATABASE student_db;
   USE student_db;
   CREATE TABLE students (
       rollNo INT PRIMARY KEY,
       name VARCHAR(50),
       age INT,
       email VARCHAR(50),
       mark DOUBLE
   );
   
2. Update DB credentials in DBConnection.java

3. Add MySQL Connector JAR in your project’s classpath

4. Run Main.java