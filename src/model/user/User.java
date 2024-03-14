package model.user;

import service.IPostService;

public abstract class User extends GuestUser implements IPostService{
	protected String nameSurname;
	private String username;
	private String password;
	
	//Getters
	public String getNameSurname() {
		return nameSurname;
	}
	public String getUsername() {
		return username;
	}
	//TODO: Maybe change accessibility.
	public String getPassword() {
		return password;
	}
	
	//Setters
	public abstract void setNameSurname(String nameSurname);
	
	public void setUsername() {
		this.username = super.getUserID() + nameSurname.substring(0, 5).trim();
	}
	
	public void setPassword(String password) {
		if (password != null)
			this.password = password;
		else
			this.password = "Undefined";
	}
	
	//Constructors
	public User() {
		super();
		setPassword("Undefined");
	}
	
	public User(String password) {
		super();
		setPassword(password);
	}
	
	public String toString() {
		return "Registered User - " + super.toString() + ":" + nameSurname + "(" + username + ")";
	}
	
	//TODO: login and followPage
}
