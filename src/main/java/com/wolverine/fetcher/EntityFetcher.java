package com.wolverine.fetcher;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class EntityFetcher {

	DBCollection getJSONForMongoDB(
			Map<String, Map<String, Object>> entityStructure, DB db) {
		DBCollection collection = null;
		if (entityStructure != null) {
			for (Map.Entry<String, Map<String, Object>> entry : entityStructure
					.entrySet()) {

				collection = db.createCollection(entry.getKey(),
						new BasicDBObject());
				Map<String, Object> entity2 = entry.getValue();
				Iterator iterator = entity2.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry entry1 = (Entry) iterator.next();
					DBObject dbObject = new BasicDBObject(entry1.getKey()
							.toString(), entry1.getValue());
					collection.insert(dbObject);
					iterator.remove();
				}
			}
		}
		return collection;

	}


}
