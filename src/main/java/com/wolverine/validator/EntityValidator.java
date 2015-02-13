package com.wolverine.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wolverine.jaxb.Entity;
import com.wolverine.jaxb.EntityValue;
import com.wolverine.jaxb.ListWrapper;
import com.wolverine.jaxb.Type;

public class EntityValidator {

	public Map<String, Map<String, List<? extends Type>>> validate(Entity entity) {
		if (entity.getCollectionMap() == null
				|| entity.getCollectionMap().isEmpty()
				|| entity.getEntityValueList() == null
				|| entity.getEntityValueList().isEmpty()
				|| entity.getEtity() == null || entity.getEtity().isEmpty()) {
			return null;
		}
		Map<String, ListWrapper> collectionMap = entity.getCollectionMap();
		Map<String, ListWrapper> entityMap = entity.getEtity();
		List<EntityValue> entityValueList = entity.getEntityValueList();
		Set<String>entitySet= new HashSet<String>();
		Set<String>entitySet1= new HashSet<String>();
		for(String collectionName:collectionMap.keySet()){
			entitySet.add(collectionName);
		}
		for(String entityString:entityMap.keySet()){
			entitySet1.add(entityString);
		}
		
		return true;

	}

}
