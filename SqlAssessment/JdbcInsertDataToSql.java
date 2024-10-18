package sqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcInsertDataToSql {

	public static void main(String[] args) throws SQLException {
		
		String Url="jdbc:mysql://localhost:3306/GuviAssessment";
		String uname="root";
		String psw="MySql1";
		
		Connection con=DriverManager.getConnection(Url,uname,psw);  //jdbc connection 
		//Approach 1 for inserting data
		/*
		 * PreparedStatement ps=con.prepareStatement
		 * ("insert into EmployeeInfo values(101,'Jenny',25,10000)"); PreparedStatement
		 * ps1=con.prepareStatement
		 * ("insert into EmployeeInfo values(102,'Jacky',30,20000)"); PreparedStatement
		 * ps2=con.prepareStatement
		 * ("insert into EmployeeInfo values(103,'Joe',20,40000)"); PreparedStatement
		 * ps3=con.prepareStatement
		 * ("insert into EmployeeInfo values(104,'John',40,80000)"); PreparedStatement
		 * ps4=con.prepareStatement
		 * ("insert into EmployeeInfo values(105,'Shameer',25,90000)");
		 * ps.executeUpdate(); ps1.executeUpdate(); ps2.executeUpdate();
		 * ps3.executeUpdate(); ps4.executeUpdate();
		 */
		//Approach 2
		Statement stmt = con.createStatement();
        String sql = "insert into EmployeeInfo (empcode, empname, emppage, esalary) values " + 
                "(10, 'Sherman',20, 100000)," +
                "(11, 'Mary',21, 50000)," +
                "(12, 'Paul',22, 65000)";
        stmt.executeUpdate(sql);
        
        System.out.println("Data insertion sucessful");
	}

}
