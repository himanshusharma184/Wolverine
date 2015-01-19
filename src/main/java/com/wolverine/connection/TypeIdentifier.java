package com.wolverine.connection;

/*
 *  @author himanshusharma
 */

public enum TypeIdentifier {
	MONGODB("mongodb"), ELASTICSEARCH("elasticsearch");
	private String type;

	private TypeIdentifier(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.type;
	}
}
