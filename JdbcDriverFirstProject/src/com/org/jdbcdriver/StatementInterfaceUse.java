package com.org.jdbcdriver;

import java.sql.*;

public class StatementInterfaceUse {

	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver Created");
		Connection con= DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			Statement ste=con.createStatement();
			int val= ste.executeUpdate("insert into register value('new','new@gmail.com',544486)");//insert data into database
			if(val!=0)
			{
				System.out.println("The statement executed");
			}
			else
			{
				System.out.println("Ststement not Executed");
			}
		}
		else
		{
			System.out.println("Not Connected");
		}
		

	}

}
