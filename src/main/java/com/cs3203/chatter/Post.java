package com.cs3203.chatter;

import org.springframework.data.annotation.Id;

public class Post {

    @Id
    private Long id;
    private String content;
	// Many-to-One relationship with User
    private User user;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
