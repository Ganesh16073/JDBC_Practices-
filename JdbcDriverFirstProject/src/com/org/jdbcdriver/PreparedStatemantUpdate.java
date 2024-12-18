package com.org.jdbcdriver;
import java.sql.*;
import java.util.*;
public class PreparedStatemantUpdate {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	
	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection Established");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name where you will change all data");
			String Cname=sc.nextLine();
			System.out.println("Enter the Name to Update");
			String name=sc.nextLine();
			System.out.println("Enter the Email to update");
			String email=sc.nextLine();
			System.out.println("Enter the Contact to update");
			String contact=sc.nextLine();
			System.out.println("Enter the Address to update");
			String Address=sc.nextLine();
			PreparedStatement sta=con.prepareStatement("update register set name=?, email=?, contact=?,Address=? where name='"+Cname+"' ");
			sta.setString(1, name);
			sta.setString(2, email);
			sta.setString(3, contact);
			sta.setString(4, Address);
			int val=sta.executeUpdate();
			if(val>0)
			{
				System.out.println("Query Executed");
				sta=con.prepareStatement("select * from register");
				ResultSet rs=sta.executeQuery();
				System.out.println();
				System.out.println("This is all Data in register Table");
				System.out.println("----------------------------------------------------------------");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				}
			}
			else
			{
				System.out.println("Query Not Executed");
			}	
		}
		else
		{
			System.out.println("Connection  Not Established");
		}
		
	}

}
