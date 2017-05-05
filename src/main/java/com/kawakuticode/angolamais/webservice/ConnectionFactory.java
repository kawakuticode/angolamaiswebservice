package com.kawakuticode.angolamais.webservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException {
		URI dbUri;
		Connection connection = null;

		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
			try {

				String username = dbUri.getUserInfo().split(":")[0];
				String password = dbUri.getUserInfo().split(":")[1];

				Class.forName("org.postgresql.Driver");
				String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
				connection = DriverManager.getConnection(dbUrl, username, password);

			} catch (SQLException s) {
				throw new RuntimeException(s);
			}
		} catch (URISyntaxException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

	public Connection getLocalConnection() throws ClassNotFoundException {

		String dbUrl = "jdbc:postgresql://127.0.0.1:5432/angolamaisdb";
		try {

			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}  
	}
}
