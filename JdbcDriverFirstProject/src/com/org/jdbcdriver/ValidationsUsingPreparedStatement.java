package com.org.jdbcdriver;
import java.util.*;
import java.sql.*;
public class ValidationsUsingPreparedStatement {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	
	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		Scanner sc=new Scanner(System.in);
		if(con!=null)
		{
			System.out.println("Established Connection");
			System.out.println("Enter the Name to check in database");
			String name=sc.nextLine();
			PreparedStatement sta=con.prepareStatement("select *from register where name=?");
			sta.setString(1, name);
			ResultSet rs=sta.executeQuery();
			if(rs.next())
			{
				System.out.println("User Data Found");
				do
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				}while(rs.next());
				
			}
			else
			{
				System.out.println("There is no data of name in table");
			}
		}
		else
		{
			System.out.println("Connection not Established");
		}
		
	}

}
