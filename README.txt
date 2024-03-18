README

Kaitlyn Warhurst

Youtube Demo Video: https://youtu.be/uA6CQEDn2rI
--------------------------------------------------------------------------------------------------------

Creating the Database in PostgreSQL:

Step 1. Once PGAdmin4 is open, and the server is running, right click on Databases and click create
	Name the Database "Students" 


Step 2. Right click on the newly created Students Database and click "Query Tool"

Step 3. Two options

	Option 1: Copy and paste the following into the Query tool and run it 

create TABLE students (
	student_id	SERIAL PRIMARY KEY,
	first_name	TEXT	NOT NULL,
	last_name 	TEXT	NOT NULL,
	email		TEXT	UNIQUE NOT NULL,
	enrollment_date	DATE
);


INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

	Option 2: In the query tool click open and then select the students.sql file provided and then click run


Your database is now created
--------------------------------------------------------------------------------------------------------

Compiling and Running the Code:

The easiest way: Using IntelliJ IDEA

Step 1: Open IntelliJ and click in the top left corner the main menu button. Click "open"
	Navigate to the folder containing all the code - in this case the folder is Assignment3COMP3005 and open that folder

Step 2: At the top there is a green play button that will run the 'main' file and print the output of the following tests:

	getAllStudents();
        addStudent("Tony", "Stark", "tonystark@abc.com", "2022-09-03");
        getAllStudents();
        int x = getStudentID("tonystark@abc.com");
        updateStudent(x, "tonystark@def.com");
        getAllStudents();
        deleteStudent(x);
        getAllStudents();
	
---------------------------------------------------------------------------------------------------------

Notes:

Assignment completed using JDBC. Setup as shown in the PostgreSQL - JDBC Example in week 6 lectures. Created using IntelliJ. 

The code itself is all in main.java (in Assignment3COMP3005\src\main\java)

The connection to the database is using the defaults:
Database name: Students
Port: 5432
User: postgres
password: admin

If any of the above is different for you, you need to change the relevant details in the main.java file (line 12,13 and 14)  
