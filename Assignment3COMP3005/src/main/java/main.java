//Kaitlyn Wahurst

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

public class main {
//    static variables used by all the functions to establish a connection with the database of ProstgreSql
//    All of below must be updated for specific database - currently its the defaults
    static String url = "jdbc:postgresql://localhost:5432/Students";
    static String user = "postgres";
    static String password = "admin";

//Function to get all students and prints them to console
    public static void getAllStudents(){

        try{
//            Establish connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            //The SQL query that will be run
            String getAllStudentsQuery = "SELECT * FROM students";
            //Executing the query and collecting the results
            ResultSet getAllStudentsResults = statement.executeQuery(getAllStudentsQuery);
            //printing column headings
            System.out.println("\nStudent_ID \t \t First_Name \t \t Last_name \t \t Email \t \t Enrollment Date");
            //printing the results aka all the students
            while(getAllStudentsResults.next()){
                int id = getAllStudentsResults.getInt("student_id");
                String first_name = getAllStudentsResults.getString("first_name");
                String last_name = getAllStudentsResults.getString("last_name");
                String email = getAllStudentsResults.getString("email");
                Date date = getAllStudentsResults.getDate("enrollment_date");
                System.out.println(id + "\t \t" + first_name + "\t \t" + last_name + "\t \t" + email + "\t \t" + date);

            }


        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //Adds a student to the database
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date){

        try{
            //            Establish connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            //The SQL query that will be run
            String addStudentQuery = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')";
            //Executing the query
            statement.executeUpdate(addStudentQuery);


        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    //Updates the student's email with the matching student id to the parameter's new email
    public static void updateStudent(int student_id, String new_email){

        try{
            //            Establish connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            //The SQL query that will be run
            String updateEmailQuery = "UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id   ;
            //Executing the query
            statement.executeUpdate(updateEmailQuery);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //Deletes the student from the database with the matching student id
    public static void deleteStudent(int student_id){

        try{
            //            Establish connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            //The SQL query that will be run
            String deleteStudentQuery = "DELETE FROM students WHERE student_id = " +student_id ;
            //Executing the query
            statement.executeUpdate(deleteStudentQuery);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //Not in requirements but extra to make my test cases always work
    //Gets the student id linked to the parameter email
    public static int getStudentID(String email){

        try{
            //            Establish connection
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            //The SQL query that will be run
            String getStudentIDQuery = "SELECT student_id FROM students WHERE email =  '" +email + "'" ;
            //Executing query, collecting results and returning the relevant id
            ResultSet rs = statement.executeQuery(getStudentIDQuery);
            int id = 0;
            while(rs.next()){
                id = rs.getInt("student_id");
            }
            return id;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }

    //Tests each of the queries, prints out the results after each update query to verify the results
    public static void main(String[] args){
        getAllStudents();
        addStudent("Tony", "Stark", "tonystark@abc.com", "2022-09-03");
        getAllStudents();
        int x = getStudentID("tonystark@abc.com");
        updateStudent(x, "tonystark@def.com");
        getAllStudents();
        deleteStudent(x);
        getAllStudents();
    }
}