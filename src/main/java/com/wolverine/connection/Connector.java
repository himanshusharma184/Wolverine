package com.wolverine.connection;

import com.mongodb.DB;
import com.mysql.jdbc.Connection;

public interface Connector {

	Connection getMySqlConnection(SqlConnector connector);

	DB getMongoDBConnection(String dbName);

	void close(Connection connection);
}
