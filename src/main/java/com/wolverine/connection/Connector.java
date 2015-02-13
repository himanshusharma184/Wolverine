package com.wolverine.connection;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mysql.jdbc.Connection;

public interface Connector {

	Connection getMySqlConnection();

	DB getMongoDBConnection()throws UnknownHostException;

	void close(Connection connection);
}
