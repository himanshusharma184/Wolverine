package com.wolverine.fetcher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.wolverine.jaxb.ListWrapper;

public class DataFetcher {

	public Map<String, ResultSet> getData(Map<String, ListWrapper> collectionMap,
			Connection connection) throws SQLException {
		Map<String, ResultSet> result = new HashMap<String, ResultSet>();

		if (collectionMap != null && !collectionMap.isEmpty()) {
			for (String table : collectionMap.keySet()) {
				Statement statement = connection.createStatement();
				String sql = "SELECT * FROM " + table;
				ResultSet rs = statement.executeQuery(sql);
				if (rs != null) {
					result.put(table, rs);
				}
			}
			return result;
		}

		return null;

	}
	
}
