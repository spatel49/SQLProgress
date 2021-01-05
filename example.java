import java.sql.*;

public class example {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   //the user name; You can change it to your username (by default it is root).
   static final String PASS = "root";
   //the password; You can change it to your password (the one you used in MySQL server configuration).

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 1: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 2: Open a connection to database
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      System.out.println("Creating database...");
      stmt = conn.createStatement();

      //STEP 3: Use SQL to Create Database;
      String sql1 = "DROP DATABASE VehicleOffice";
      stmt.executeUpdate(sql1);
      String sql = "CREATE DATABASE IF NOT EXISTS VehicleOffice";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");

      //STEP 4: Use SQL to select the database;
      sql = "use VehicleOffice";
      stmt.executeUpdate(sql);

     //STEP 5: Use SQL to create Tables;
     //STEP 5.1: Create Table Branch;
      sql = "create table IF NOT EXISTS branch( branch_id integer not null PRIMARY KEY, " +
      		"branch_name varchar(20) not null," +
      		"branch_addr varchar(50)," +
      		"branch_city varchar(20) not null," +
      		"branch_phone integer)";
      stmt.executeUpdate(sql);

      //STEP 5.2: Create Table Driver;
      sql = "create table IF NOT EXISTS driver(driver_ssn integer not null PRIMARY KEY," +
      		"driver_name varchar(20) not null," +
      		"driver_addr varchar(50) not null," +
      		"driver_city varchar(20) not null," +
      		"driver_birthdate date not null," +
      		"driver_phone integer)";
      stmt.executeUpdate(sql);

     //STEP 5.3: Create Table License;
     sql = "create table IF NOT EXISTS license(license_no integer not null PRIMARY KEY," +
            "driver_ssn integer not null," +
            "license_type char not null," +
            "license_class integer not null," +
            "license_expiry date not null," +
            "issue_date date not null," +
            "branch_id integer not null)";
      stmt.executeUpdate(sql);

      //STEP 5.4: Create Table Exam;
      sql = "create table IF NOT EXISTS exam(driver_ssn integer not null," +
      		"branch_id integer not null," +
      		"exam_date date not null," +
      		"exam_type char not null," +
            "exam_score integer not null,"+
            "PRIMARY KEY(driver_ssn, branch_id, exam_date))";
      stmt.executeUpdate(sql);

       //STEP 6: Use SQL to insert tuples into tables;
       //STEP 6.1: insert tuples into Table Branch;
        sql = "insert IGNORE into branch values(10, 'Main', '1234 Main St.', 'Hoboken', 5551234)";
        stmt.executeUpdate(sql);

        sql = "insert IGNORE into branch values(20, 'NYC', '23 No.3 Road', 'NYC', 5552331)";
        stmt.executeUpdate(sql);

        sql = "insert IGNORE into branch values(30, 'West Creek', '251 Creek Rd.', 'Newark', 5552511)";
        stmt.executeUpdate(sql);

        sql = "insert IGNORE into branch values(40, 'Blenheim', '1342 W.22 Ave.', 'Princeton', 5551342)";
        stmt.executeUpdate(sql);

        //Your Task 3: insert the rest of tuples in Table Branch;
        
       //STEP 6.2: insert tuples into Table driver;
        sql = "insert IGNORE into driver values(11111111, 'Bob Smith', '111 E. 11 St.', 'Hoboken', '1975-01-01', 5551111)";
        stmt.executeUpdate(sql);

        sql = "insert IGNORE into driver values(22222222, 'John Walters', '222 E. 22 St.', 'Princeton', '1976-02-02', 5552222)";
        stmt.executeUpdate(sql);
        
        sql = "insert IGNORE into driver values(33333333, 'Troy Rops', '333 W.33 Ave', 'NYC', '1970-03-03', 5553333)";
        stmt.executeUpdate(sql);

        sql = "insert IGNORE into driver values(44444444, 'Kevin Mark', '444 E.4 Ave.', 'Hoboken', '1974-04-04', 5554444)";
        stmt.executeUpdate(sql);

      //Your Task 4: insert the rest of tuples in Table Driver;

      //STEP 6.3: insert tuples into Table license;
      sql = "insert IGNORE into license values(1, 11111111, 'D', 5, '2022-05-24', '2017-05-25', 20)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into license values(2, 22222222, 'D', 5, '2023-08-29', '2016-08-29', 40)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into license values(3, 33333333, 'L', 5, '2022-12-27', '2017-06-27', 20)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into license values(4, 44444444, 'D', 5, '2022-08-30', '2017-08-30', 40)";
      stmt.executeUpdate(sql);
      //Your Task 5: insert all tuples into Table license;

      //STEP 6.4: insert all tuples into Table exam;
      sql = "insert IGNORE into exam values(11111111, 20, '2017-05-25', 'D', 79)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(11111111, 20, '2017-12-02', 'L', 67)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(22222222, 30, '2016-05-06', 'L', 25)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(22222222, 40, '2016-06-10', 'L', 51)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(22222222, 40, '2016-08-29', 'D', 81)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(33333333, 10, '2017-07-07', 'L', 45)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(33333333, 20, '2017-06-27', 'L', 49)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(33333333, 20, '2017-07-27', 'L', 61)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(44444444, 10, '2017-07-27', 'L', 71)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(444444444, 20, '2017-08-30', 'L', 65)";
      stmt.executeUpdate(sql);

      sql = "insert IGNORE into exam values(444444444, 40, '2017-09-01', 'L', 62)";
      stmt.executeUpdate(sql);
      //Your Task 6: insert all tuples into Table exam;

        //STEP 7: Use SQL to ask queries and retrieve data from the tables;
        //An example to retrieve branch ID, name, address from Table Branch, and display these values;
        Statement s = conn.createStatement();
        s.executeQuery ("SELECT branch_id, branch_name, branch_addr FROM branch");
        ResultSet rs = s.getResultSet();
        int count = 0;
        while (rs.next ())
        {
            int idVal = rs.getInt ("branch_id");
            String nameVal = rs.getString ("branch_name");
            String addrVal = rs.getString ("branch_addr");
            System.out.println (
                    "branch id = " + idVal
                    + ", name = " + nameVal
                    + ", address = " + addrVal);
            ++count;
        }
        rs.close ();
        s.close ();
        System.out.println (count + " rows were retrieved");

        //Your Task 7: Write SQL for Q1 - Q4 in Lab instruction and display the answers.
        System.out.println("Question 1:");
        Statement s1 = conn.createStatement();
        s1.executeQuery ("SELECT driver_name FROM driver NATURAL JOIN branch NATURAL JOIN license WHERE branch_city='NYC'");
        ResultSet rs1 = s1.getResultSet();
        while (rs1.next ())
        {
            String driverName = rs1.getString ("driver_name");
            System.out.println (
                    "driver name = " + driverName);
        }
        rs.close ();
        s.close ();
        System.out.println();

        System.out.println("Question 2:");
        Statement s2 = conn.createStatement();
        s2.executeQuery ("SELECT driver_name FROM driver NATURAL JOIN license NATURAL JOIN branch WHERE (license_expiry < '2022-12-31')");
        ResultSet rs2 = s2.getResultSet();
        while (rs2.next ())
        {
            String driverName = rs2.getString ("driver_name");
            System.out.println (
                    "driver name = " + driverName);
        }
        rs.close ();
        s.close ();
        System.out.println();

        System.out.println("Question 3:");
        Statement s3 = conn.createStatement();
        s3.executeQuery ("SELECT driver_name FROM driver NATURAL JOIN exam natural join license natural join branch "
                    + "WHERE license_type=exam_type "
                    + "GROUP BY driver_name, driver_ssn "
                    + "HAVING COUNT(exam_score) >= 2");
        ResultSet rs3 = s3.getResultSet();
        while (rs3.next ())
        {
            String driverName = rs3.getString ("driver_name");
            System.out.println (
                    "driver name = " + driverName);
        }
        rs.close ();
        s.close ();
        System.out.println();

        System.out.println("Question 4:");
        Statement s4 = conn.createStatement();
        s4.executeQuery ("SELECT DISTINCT D1.driver_name, E1.driver_ssn "
                        + "FROM driver D1, exam E1 "
                        + "WHERE D1.driver_ssn=E1.driver_ssn AND E1.driver_ssn not in ("
                                 + "SELECT E2.driver_ssn "
                                 + "FROM driver D2, exam E2 "
                                 + "WHERE D2.driver_ssn=E2.driver_ssn AND EXISTS ("
                                             + "SELECT E3.driver_ssn "
                                             + "FROM exam E3 "
                                             + "WHERE(E2.driver_ssn=E3.driver_ssn AND E3.exam_date > E2.exam_date AND E3.exam_score > E2.exam_score)))"); 
        ResultSet rs4 = s4.getResultSet();
        while (rs4.next ())
        {
            String driverName = rs4.getString ("driver_name");
            System.out.println (
                    "driver name = " + driverName);
        }
        rs.close ();
        s.close ();
        System.out.println();

      }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
