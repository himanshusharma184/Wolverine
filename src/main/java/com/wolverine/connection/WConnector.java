package com.wolverine.connection;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mysql.jdbc.Connection;

public class WConnector implements Connector {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public Connection getMySqlConnection(SqlConnector connector) {
		Connection connection = null;
		if (connector.getDb_url() == null || connector.getUser_id() == null
				|| connector.getPwd() == null) {
			new Throwable("Data missing in SqlConnector");
		}
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(
					connector.getDb_url(), connector.getUser_id(),
					connector.getPwd());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public DB getMongoDBConnection(String dbName) {
		MongoClient client = null;
		DB db = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (client != null) {
			db = client.getDB(dbName);
		}
		return db;
	}

}
