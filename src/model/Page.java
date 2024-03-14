package model;

import java.util.ArrayList;

import model.user.User;

public class Page {
	private String title;
	private String description;
	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<Post> postsInPage = new ArrayList<Post>();
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	//Setters
	public void setTitle(String title) {
		if (title != null && title.length() > 5 && title.length() < 20)
			this.title = title;
		else
			this.title = "Undefined";
	}
	
	public void setDescription(String description) {
		if (description != null && description.length() > 3 && description.length() < 100)
			this.description = description;
		else
			this.description = "Undefined";
	}
	
	
}
