package com.wolverine.Convertor;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.wolverine.jaxb.EntityValue;
import com.wolverine.jaxb.ListWrapper;

public class ResultSetToJSONConvertor {

	public ResultSetToJSONConvertor() {

	}

	public List<String> convert(Map<String, ResultSet> result,
			Map<String, ListWrapper> originalQuery,
			Map<String, ListWrapper> conversionQuery,
			List<EntityValue> collapseList) {

		for (EntityValue entityValue : collapseList) {
			if (originalQuery.keySet().contains(entityValue.getKey())) {

			}
		}
		return null;

	}

}
