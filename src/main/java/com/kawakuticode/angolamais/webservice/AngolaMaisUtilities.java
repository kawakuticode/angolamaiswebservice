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

//import org.json.JSONArray;

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
			tmp.put(i, r.getObject(column_name).toString());
			array_temp.add(tmp);
			i++;
		}
		return array_temp;
	}

	public String stringArrayFromDb(ResultSet r, String column_name) throws SQLException {

		// String result="[";
		StringBuilder builderString = new StringBuilder();
		// String result=new String();
		while (r.next()) {
			if (r.isLast()) {
				builderString.append(r.getString(column_name));
				// +"]";
			} else {
				builderString.append(r.getString(column_name) + ",");
			}
		}
		return builderString.toString();
	}
}
