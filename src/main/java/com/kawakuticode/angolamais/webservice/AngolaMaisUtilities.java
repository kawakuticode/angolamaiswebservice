package com.kawakuticode.angolamais.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.eclipse.persistence.oxm.json.JsonArrayBuilderResult;

/**
 * @author russeliusernestius
 *
 */

import org.json.simple.*;

public class AngolaMaisUtilities {

	public AngolaMaisUtilities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSONArray buildArrayFromDb(ResultSet r, String column_name) throws SQLException {

		JSONArray array_temp = new JSONArray();
		int i = 0;
		while (r.next()) {
			JSONObject tmp = new JSONObject();
			tmp.put(i, r.getObject(column_name));
			array_temp.add(tmp);
			i++;
		}
		return array_temp;
	}

}
