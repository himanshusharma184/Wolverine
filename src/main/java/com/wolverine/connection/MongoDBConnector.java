package com.wolverine.connection;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBConnector {
	private String hostID = null;
	private Integer port = null;
	private String db = null;

	public MongoDBConnector() {

	}

	public MongoDBConnector(String hostID, Integer port, String db) {
		this.port = port;
		this.hostID = hostID;
		this.db = db;
	}

	public DB getDbConnection() throws UnknownHostException {
		if (hostID != null && port != null && db != null) {
			MongoClient client = new MongoClient(hostID, port);
			DB db = client.getDB(this.db);
			return db;
		} else {
			MongoClient client = new MongoClient();
			DB db = client.getDB("Wolverine");
			return db;
		}
	}
}
