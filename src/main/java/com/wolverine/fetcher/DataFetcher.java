package com.wolverine.fetcher;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

public class DataFetcher {

	Map<String, Map<String, Object>> getData(Connection connection,
			List<String> entityList) {
		Map<String, Map<String, Object>> result = new HashMap<String, Map<String, Object>>();
		for (String type : entityList) {
			Statement stmt;
			try {
				stmt = connection.createStatement();
				String  sql = "SELECT * FROM " + type;
				ResultSet results = stmt.executeQuery(sql);
				while(results.next())
				{
					Reader value = results.getNCharacterStream(0);
					//value.
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}
}
