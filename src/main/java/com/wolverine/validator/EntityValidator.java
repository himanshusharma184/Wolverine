package com.wolverine.validator;

import java.util.List;
import java.util.Map;

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
		return null;

	}

}
