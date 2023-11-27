package com.cs3203.chatter;

public class User {

    private String id = "1";
    private String username = "null";
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    public User()
    {

    }

    public User(String id, String username)
    {
        this.id = id;
        this.username = username;
    }
}