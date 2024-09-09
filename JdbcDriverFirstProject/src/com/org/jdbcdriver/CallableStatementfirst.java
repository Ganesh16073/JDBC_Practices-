package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class CallableStatementfirst {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	
	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection Established");
			// CallableStatement work with Procedure and procedure which we creat in sqlComanad line like
			// delimiter //
			// create procedure procedure_Name(coloum_Name dataType,coloum_Name dataType....
			// )
			// begin 
			// insert into register value(column_name, column_Name...);
			// end
			// //
			// this procedure is used to sqlQuery from begin to end. it can be used by procedure name multipletime
			// which can be used for Reuseablity
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Details to Add in Register table");
			System.out.println("-------------------------");
			System.out.println("Enter the Name to Add");
			String name=sc.nextLine();
			
			System.out.println("Enter the Email to Add");
			String email=sc.nextLine();
			
			System.out.println("Enter the Contact to Add");
			String contact=sc.nextLine();
			
			System.out.println("Enter the Address to Add");
			String address=sc.nextLine();
			
			
			CallableStatement csta=con.prepareCall("{call saveRecordInRegister(?,?,?,?)}");
			csta.setString(1,name);
			csta.setString(2, email);
			csta.setString(3, contact);
			csta.setString(4, address);
			boolean check=csta.execute();
			if(!check)
			{
				System.out.println("CallAble Statement is Executed");
			}
			else
			{
				System.out.println("Callable Statement Not Executed");
			}
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
		
	}

}
