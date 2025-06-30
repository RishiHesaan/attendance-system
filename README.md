# Student Attendance Management System

This is a simple web-based application designed to manage **daily attendance** in a school. The system allows:

- Teachers to log in securely.
- Teachers to mark each student in a class as **Present** or **Absent**.
- Attendance to be **saved** to a file for later reference.

---

## How to Download the Project from GitHub

If someone has shared the GitHub link with you, follow these steps to get it on your computer:

1. Visit the GitHub link provided (example: https://github.com/RishiHesaan/attendance-system).
2. Click the green **`Code`** button.
3. Select **`Download ZIP`**.
4. After downloading, **right-click the ZIP file** and choose **Extract All**.
5. Open the folder named **`attendance-system`**.

You are now ready to run the application.

## Project Folder Structure

attendance-system/
│
├── client/ → Frontend files (login and attendance UI)
│ ├── login.html
│ ├── home.html
│ └── auth.js
│
├── server/ → Backend Java Spring Boot project
│ ├── controller/
│ │ ├── LoginController.java
│ │ └── AttendanceController.java
│ ├── util/
│ │ └── JwtUtil.java
│ └── users.txt → Stores valid usernames and passwords
│
├── docs/ → Folder containing screenshots for each task
│ ├── task1_login_screen.png
│ ├── task2_dashboard_view.png
│ ├── task3_submit_success.png
│
└── ReadMe.md

---

## How to Use the Application

### 1. Run the Server (Backend)

1. Open **Command Prompt** or **Terminal**.
2. Go to the folder: `attendance-system/server`
3. Type and run the command:

   mvn spring-boot:run

4. Wait until you see the message:  
   `Started ServerApplication...`  
   This means the backend is now running.

---

### 2. Open the Frontend (Client)

1. Go to the folder: `attendance-system/client`
2. Double-click the file named: `login.html` or Go to the folder: `attendance-system/client` and run command npx serve . And click the URL please.
3. It will open in your default browser

---

## Login Credentials

Use one of the following to log in:

Username: admin  
Password: secret

OR

Username: teacher  
Password: secret

---

## Features

- Secure login screen
- Dashboard showing classroom-wise student list
- Mark each student as "Present" or "Absent"
- Add or remove students
- Save attendance (writes to file on server)
- Logout option

---

## Screenshots Folder

All required screenshots have been saved in the `docs/` folder:

1. **Task 1** — Login Page UI → `task1_login_screen.png`
2. **Task 2** — Dashboard Page → `task2_dashboard_view.png`
3. **Task 3** — Submission Success → `task3_submit_success.png`

You can open these files directly to verify each task.

If you face any errors:

- Make sure port 8080 is free.
- Ensure you run `mvn spring-boot:run` from the `server/` folder.
- Make sure you're opening `login.html` from the `client/` folder.

---

Thank you for reviewing the project!
