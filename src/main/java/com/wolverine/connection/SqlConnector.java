package com.wolverine.connection;

public class SqlConnector {
	private String user_id = null;
	private String pwd = null;
	private String db_url = null;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

}
