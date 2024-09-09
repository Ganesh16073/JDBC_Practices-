package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class PreparedDeleteStatement {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Established Connection");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name Where to Delete Data");
			String name=sc.nextLine();
			PreparedStatement sta=con.prepareStatement("delete from register where name=?"); // write query ? is used to pass data
			sta.setString(1, name); // pass data at 1st ?
			int val=sta.executeUpdate(); // execute Query
			if(val>0) // check Query
			{
				System.out.println("Query Executed");
			}
			else
			{
				System.out.println("Query Note Executed");
			}
			System.out.println();
			System.out.println("The Data in table Register is ");
			sta=con.prepareStatement("select *from register"); // write query to Represent data in table
			ResultSet rs=sta.executeQuery(); // execute Query and Story in ResultSet
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		}
		else
		{
			System.out.println("Connection Not Established");
		}
	}

}
