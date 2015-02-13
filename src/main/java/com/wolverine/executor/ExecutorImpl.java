package com.wolverine.executor;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.wolverine.connection.Connector;
import com.wolverine.connection.TypeIdentifier;
import com.wolverine.fetcher.DataFetcher;
import com.wolverine.jaxb.Entity;

/*
 *  @author himanshusharma
 */
public class ExecutorImpl implements Executor {

	static public ExecutorImpl executorImpl;

	private ExecutorImpl() {

	}

	public ExecutorImpl getInstance() {
		if (executorImpl != null) {
			return executorImpl;
		} else {
			return executorImpl = new ExecutorImpl();
		}
	}

	public void execute(Connector connector, String file_path,
			TypeIdentifier identifier) {
		JAXBContext jaxbContext1;
		try {
			jaxbContext1 = JAXBContext.newInstance(Entity.class);
			Unmarshaller jaxbUnmarshaller1 = jaxbContext1.createUnmarshaller();
			Entity entity = (Entity) jaxbUnmarshaller1.unmarshal(new File(
					file_path));
			execute(connector, entity, identifier);
		} catch (JAXBException e) {
			new Throwable(e);
		} finally {
			// connection close code missing
		}

	}

	public void execute(Connector connector, Entity entity,
			TypeIdentifier identifier) {
		switch (identifier) {
		case ELASTICSEARCH: {
			DataFetcher dataFetcher = new DataFetcher();
			try {
				Map<String, ResultSet> resultMap = dataFetcher.getData(
						entity.getCollectionMap(),
						connector.getMySqlConnection());
				

			} catch (SQLException e) {
				new Throwable("Connection is bad or Unidentified relationship");
			}
			break;
		}
		case MONGODB: {

			break;
		}
		default: {
			break;
		}
		}

	}

}
