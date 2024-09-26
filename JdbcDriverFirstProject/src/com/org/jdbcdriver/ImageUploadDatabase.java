package com.org.jdbcdriver;
import java.sql.*;
import java.io.*;
public class ImageUploadDatabase {
	public static final String url="jdbc:mysql://localhost:3306/mydb";
	public static final String userName="root";
	public static final String password="Ganesh4237@";
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Established Connection");
			File f=new File("D:\\Resume\\profile.jpg");
			FileInputStream inf=new FileInputStream(f);
			PreparedStatement sta=con.prepareStatement("insert into uploadimage (name,image) value(?,?)");// coloum type will be blon
			sta.setString(1,"image");
			long l=f.length();
			int size=(int)l;
			sta.setBinaryStream(2,inf,size);
			int value=sta.executeUpdate();
			if(value>0)
			{
				System.out.println("Image Saved in DataBase");
			}
			else
			{
				System.out.println("image Not Saved");
			}
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}
	
}
