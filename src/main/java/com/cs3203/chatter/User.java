package com.cs3203.chatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public class User {

    @Id
    private Integer id;

    private String userName = "null";

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}
    
    public User()
    {

    }

    public User(Integer id, String username)
    {
        this.id = id;
        this.userName = username;
    }
}