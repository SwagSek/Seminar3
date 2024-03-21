package model.user;

import java.security.MessageDigest;

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
	public String getPassword() {
		return password;
	}
	
	//Setters
	public abstract void setNameSurname(String nameSurname);
	
	public void setUsername() {
		this.username = super.getUserID() + nameSurname.substring(0, 5).trim();
	}
	
	public void setPassword(String inputPassword) {
		if (inputPassword != null && inputPassword.matches("[A-Za-z0-9!@#$%^&*]{4,20}")) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				this.password = new String(md.digest());
			}
			catch (Exception e) {
			this.password = "undefined";
			}
		}
		else {
			this.password = "undefined";
		}
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
