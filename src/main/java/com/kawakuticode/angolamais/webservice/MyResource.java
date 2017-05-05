package com.kawakuticode.angolamais.webservice;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;

//import org.json.JSONArray;

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
	@Path("/tourism")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONArray tourismContentJson() throws ClassNotFoundException, SQLException {

		ConnectionFactory conn = new ConnectionFactory();
		// Connection connection = conn.getConnection();
		Connection connection = conn.getLocalConnection();

		AngolaMaisUtilities uti = new AngolaMaisUtilities();

		String column_name = "atraction_content";
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = stmt.executeQuery("SELECT * FROM tb_tourism");

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(uti.stringArrayFromDb(rs, column_name));
		// return uti.stringArrayFromDb(rs, column_name);

		return jsonArray;
		// return uti.buildArrayFromDb(rs, column_name);
	}

	@GET
	@Path("/radios")
	@Produces(MediaType.TEXT_PLAIN)
	public String radioContentJson() throws ClassNotFoundException, SQLException {

		ConnectionFactory conn = new ConnectionFactory();
		// Connection connection = conn.getConnection();
		Connection connection = conn.getLocalConnection();

		AngolaMaisUtilities uti = new AngolaMaisUtilities();

		String column_name = "radio_content";
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM tb_radio");
		return uti.stringArrayFromDb(rs, column_name);
	}

	@GET
	@Path("/gastronomy")
	@Produces(MediaType.TEXT_PLAIN)
	public String gastronomyContentJson() throws ClassNotFoundException, SQLException {
		ConnectionFactory conn = new ConnectionFactory();
		// Connection connection = conn.getConnection();
		Connection connection = conn.getLocalConnection();

		AngolaMaisUtilities uti = new AngolaMaisUtilities();

		String column_name = "dish_content";
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM tb_gastronomy");
		return uti.stringArrayFromDb(rs, column_name);

	}

	@GET
	@Path("/restaurant")
	@Produces(MediaType.TEXT_PLAIN)
	public String restaurantContentJson() throws ClassNotFoundException, SQLException {
		ConnectionFactory conn = new ConnectionFactory();
		// Connection connection = conn.getConnection();
		Connection connection = conn.getLocalConnection();

		AngolaMaisUtilities uti = new AngolaMaisUtilities();

		String column_name = "restaurant_content";
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("SELECT * FROM tb_restaurant");
		return uti.stringArrayFromDb(rs, column_name);
	}
}
