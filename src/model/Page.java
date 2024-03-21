package model;

import java.util.ArrayList;

import model.user.User;

public class Page {
	private String title;
	private String description;
	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}
	
	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}
	
	public ArrayList<User> getFollowers() {
		return followers;
	}
	
	//Setters
	public void setTitle(String title) {
		if (title != null && title.matches("[A-Za-z0-9 ]{5,40}"))
			this.title = title;
		else
			this.title = "Undefined";
	}
	
	public void setDescription(String description) {
		if (description != null && description.length() > 10 && description.length() < 200)
			this.description = description;
		else
			this.description = "Undefined";
	}
	
	//Constructors
	public Page() {
		setTitle("Untitled");
		setDescription("Untitled");
	}
	
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
	}
	
	public String toString() {
		return title + " (" + description + "): [" + (privatePosts.size() + publicPosts.size()) + " posts]";
	}
}
