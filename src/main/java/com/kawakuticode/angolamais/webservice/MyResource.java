package com.kawakuticode.angolamais.webservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Hello,welcome to  angola mais app webservice!";
	}

	@GET
	@Path("/history")
	@Produces(MediaType.TEXT_PLAIN)
	public String historyContentJson() throws ClassNotFoundException, SQLException {
		ConnectionFactory conn = new ConnectionFactory();

		Connection connection = conn.getConnection();
		String temp = "";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM tb_history");

		while (rs.next()) {
			temp += "" + rs.getString("content_subject") + "\n";
		}
		return temp;
	}
}
