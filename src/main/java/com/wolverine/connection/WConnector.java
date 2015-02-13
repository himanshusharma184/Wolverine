package com.wolverine.connection;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.mongodb.DB;
import com.mysql.jdbc.Connection;

public class WConnector implements Connector {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private SqlConnector sqlConnector = null;
	private MongoDBConnector mongoDBConnector = null;
	private String elasticSearchURL = null;
	private Integer elasticPort = null;

	public WConnector(SqlConnector sqlConnector,
			MongoDBConnector mongoDBConnector, String elasticSearchURL,
			int elasticPort) {
		this.sqlConnector = sqlConnector;
		this.mongoDBConnector = mongoDBConnector;
		this.elasticPort = elasticPort;
		this.elasticSearchURL = elasticSearchURL;
	}

	public Connection getMySqlConnection() {
		Connection connection = null;
		if (sqlConnector.getDb_url() == null
				|| sqlConnector.getUser_id() == null
				|| sqlConnector.getPwd() == null) {
			new Throwable("Data missing in SqlConnector");
		}
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(
					sqlConnector.getDb_url(), sqlConnector.getUser_id(),
					sqlConnector.getPwd());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public DB getMongoDBConnection() throws UnknownHostException {

		return mongoDBConnector.getDbConnection();
	}

	@SuppressWarnings("resource")
	public CreateIndexRequestBuilder getElesticSearchNode() {
		if (StringUtils.isNotBlank(elasticSearchURL) && elasticPort != null) {
			Client client = new TransportClient()
					.addTransportAddress(new InetSocketTransportAddress(
							elasticSearchURL, elasticPort));
			CreateIndexRequestBuilder createIndexRequestBuilder = client
					.admin().indices().prepareCreate("Wolverine");
			return createIndexRequestBuilder;
		} else {
			return null;
		}
	}

	public void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
