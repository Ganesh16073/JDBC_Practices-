package com.org.jdbcdriver;
import java.sql.*;
public class JdbcDriverFirstApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("This is JDBC Driver Type 4");
		System.out.println("This is First program to load JDBC Driver");
	}

}
