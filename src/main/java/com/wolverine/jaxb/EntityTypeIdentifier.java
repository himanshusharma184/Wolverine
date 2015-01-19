package com.wolverine.jaxb;

public enum EntityTypeIdentifier {
	ENTITYMAP("entityMap"), COLLECTIONMAP("collectionMap"), MAPPINGENTITY(
			"mappingEntity"), ENTITY("entity"), ID("id"), NAME(""), VALUE("");

	private String value;

	private EntityTypeIdentifier(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
