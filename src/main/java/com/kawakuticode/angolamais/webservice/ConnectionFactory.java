package com.kawakuticode.angolamais.webservice;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException {

		try {
//			  URI dbUri = new URI(System.getenv("DATABASE_URL"));
//			   if (dbUri ==
//			  null || dbUri.toString().isEmpty()) {
//			   dbUri = new URI(
//			 "postgres://gvqarcypyptepz:d15fa6d9967aa2c9d31a13fab56d39df369086d60144b49046a31e6771563776@ec2-54-228-212-74.eu-west-1.compute.amazonaws.com:5432/d36o51gua1qj15"
//			 ); 
			   //String password = dbUri.getUserInfo().split(":")[1];
			 
			   Class.forName("org.postgresql.Driver");
			 

			//Class.forName("org.postgresql.Driver");
			//String dbUrl = "jdbc:postgresql://127.0.0.1:5432/kawakutitestedb";

			

			String dbUrl =System.getenv("DATABASE_URL");
			return DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

	}
}
