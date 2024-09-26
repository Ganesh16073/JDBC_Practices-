package com.org.jdbcdriver;
import java.io.*;
import java.sql.*;
public class ResultSetMetaData {
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
			PreparedStatement sta=con.prepareStatement("Select *from Register");
			ResultSet rs=sta.executeQuery();
			java.sql.ResultSetMetaData rsmd=rs.getMetaData(); //it is used get structual detail
			int ncol=rsmd.getColumnCount();
			System.out.println("The Register COnunt is "+ncol);
			for(int i=1;i<=ncol;i++ )
			{
				System.out.println(rsmd.getColumnName(i)+"\t"+rsmd.getColumnTypeName(i)+"\t"+rsmd.getColumnDisplaySize(i));
			}
		}
		else
		{
			System.out.println("Connection not Established");
		}
	}

}
