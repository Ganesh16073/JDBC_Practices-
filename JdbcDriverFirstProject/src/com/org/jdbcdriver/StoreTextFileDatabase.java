package com.org.jdbcdriver;
import java.sql.*;
import java.io.*;
public class StoreTextFileDatabase {
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
			
			File f=new File("D:\\JDBC practics\\JdbcDriverFirstProject\\src\\com\\org\\jdbcdriver\\text.txt"); // File Path saved in f ref
			FileReader fr=new FileReader(f); // fr will read or store file
			PreparedStatement sta=con.prepareStatement("insert into insertTextFile (description, file) values (?,?)");
			sta.setString(1,"file Description");
			int l=(int)f.length(); //file length obtained
			sta.setCharacterStream(2, fr,l); // setcharacter of all file up to tength
			int value=sta.executeUpdate();
			if(value>0)
			{
				System.out.println("Saved...................");
			}
			else
			{
				System.out.println("File Not saved..................");
			}
			
		}
		else
		{
			System.out.println("Connection Not Established");
		}
		
	}

}
