package com.org.jdbcdriver;
import java.sql.*;
import java.util.*;

public class PreparedStatementFirst {
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
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the name to insert");
			String name =sc.nextLine();
			System.out.println("Enter the email to insert");
			String email =sc.nextLine();
			System.out.println("Enter the Contact to insert");
			String contact=sc.nextLine();
			PreparedStatement sta=con.prepareStatement("insert into register values(?,?,?)"); // ? is used as input specifer
			sta.setString(1, name); // push index1 => name
			sta.setString(2,email); // push index2 => email
			sta.setString(3, contact); // push index3 => contact
			int val=sta.executeUpdate();
			if(val>0)
			{
				System.out.println("Statement Executed");
				sta=con.prepareStatement("select *from register");
				ResultSet rs=sta.executeQuery(); // store result
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				}
			}
			else
			{
				System.out.println("Statement Not Executed");
			}
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}

}
