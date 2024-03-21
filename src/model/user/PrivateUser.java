package model.user;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends User{
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<User> followers = new ArrayList<User>();
	
	//Getters
	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}

	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}
	
	@Override
	public void setNameSurname(String nameSurname) {
		if (nameSurname != null && nameSurname.matches("[A-Z]{1}[a-z]{2,20} [A-Z]{1}[a-z]{2,20}"))
			super.nameSurname = nameSurname;
		else
			super.nameSurname = "Undefined";
	}
	
	//Constructors
	public PrivateUser() {
		super();
		setNameSurname("Undefined Undefined");
		setUsername();
	}
	
	public PrivateUser(String nameSurname, String password) {
		super(password);
		setNameSurname(nameSurname);
		setUsername();
	}

	public String toString() {
		return super.toString() + "[" + (privatePosts.size()+publicPosts.size()) + " posts]";
	}
	
	@Override
	public Post publishPost(String title, String msg, PostType type) throws Exception {
		if (title == null && msg == null && type == null) throw new Exception("Bad input values.");
		Post newPost = new Post(title, msg);
		if(type.equals(PostType.privatePost))
			privatePosts.add(newPost);
		else
			publicPosts.add(newPost);
		
		return newPost;
	}
}
