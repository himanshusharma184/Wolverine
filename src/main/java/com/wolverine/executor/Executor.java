package com.wolverine.executor;

import com.wolverine.connection.Connector;
import com.wolverine.connection.TypeIdentifier;
import com.wolverine.jaxb.Entity;

public interface Executor {

	public void execute(Connector connector, String file_path,
			TypeIdentifier identifier);

	public void execute(Connector connector, Entity entity,
			TypeIdentifier identifier);
}
