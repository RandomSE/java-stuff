Vaadin Online Exam System
Overview
The Vaadin Online Exam System is a web-based platform that allows students to take exams online while providing teachers with the ability to create, manage, and grade exams seamlessly. Built using Vaadin and Spring Boot, this project offers a simple and efficient solution for managing online assessments.

Features
For Students:
1- Exam Participation: Students can take multiple-choice, true/false, and short-text exams.
2- Exam Timer: Each exam includes a countdown timer that auto-submits once the time runs out.
3- View Exam Results: After completing an exam, students can view their marked tests and the grades assigned by the teacher.
4- Dispute Marking: If a student is unsatisfied with their grading, they can submit a dispute, requesting a teacher to recheck specific questions.

For Teachers:
1- Create Exams: Teachers can create exams with various question types, including multiple-choice, true/false, and short-text.
2- Memo Management: Teachers can define acceptable answers and their respective marks for short-text questions.
3- Grade Exams: The platform automatically grades multiple-choice and true/false questions and provides tools for reviewing and grading short-text answers.
4- Manage Disputes: Teachers can review and resolve disputes filed by students. Once resolved, teachers can adjust marks and reissue the results to students.


Security & Access Control:
-User Roles: The system supports two user roles — Student and Teacher. Access to different views is restricted based on these roles.
-Session Management: Secure login and session management are implemented to ensure only authorized users can access their respective functionalities.

Technologies Used:
-Vaadin: A Java-based web application framework used for creating the user interface.
-Spring Boot: Backend framework providing services such as user authentication, routing, and business logic.
-Java: The core programming language for the application logic.
-Maven: Used for building and managing project dependencies.


How It Works

-Registration & Login:
Teachers and students can register via the registration page. Once registered, users can log in to access their respective dashboards.

-Exam Creation:
Teachers can create exams by specifying the title, type of questions, and the total marks. For short-text questions, they can specify multiple correct answers along with the respective marks.

-Taking Exams:
Students select an available exam, and the timer starts. Once they complete the exam or the timer runs out, the system grades the exam and stores the results.

-Viewing Results:
Students can view their graded exams and see the marks for each question. If dissatisfied with the grading, they can dispute specific questions, prompting the teacher to review their exam.

-Managing Disputes:
Teachers review the disputed exams and adjust marks where necessary. After resolving the dispute, the teacher submits the final graded exam back to the student.


Project Structure
src/main/java/com/example/application/views: Contains the UI views for managing exams, taking exams, registration, and dispute handling.
src/main/resources/: Includes application properties and templates.
student_files/: Directory where student exam files and marked exams are stored.
disputed_exams/: Directory where disputed exams are temporarily stored for teacher review.
exams/: Directory where the created exams are stored.
exam_memos/: Directory where the memos for the exams are stored.

How to Run the Project
Requirements:
Java 17+
Maven

Steps: (first time)
1: Clone the repository.
In a folder, extract the zip file.
Open the project in Eclipse IDE.

2: Navigate to the project directory:
- you can find the path for the directory in Eclipse IDE. Right click vaadin-online-exam-system[boot] -> properties - copy the location.
- In a new powershell window:
- cd path/to/project
example (the "" are important. Do not forget them.): cd "C:\Users\username\OneDrive\Desktop\TestFolder\Task 2- Online Examination system\Task 2- Online Examination system" 

3: Build the project using Maven:
- In the same powershell window as before:
- mvn clean install

4: Run the application:
- In the same powershell window as before:
- mvn spring-boot:run

5: Access the app in the browser:
- In a web browser, put this in the search bar (Make sure nothing else is running on port 8080):
- http://localhost:8080


Note: after doing the first time steps, if you have spring tools suite, each time after you only need to follow 2 steps. If you don't have spring tools suite, well. you will need to do step 4 and 5 again, then.
1: In Eclipse IDE, right click vaadin-online-exam-system [boot], click on Run as -> Spring boot app wait for it to say application started successfully.
2: In a web browser, in the search bar enter: http://localhost:8080