package model.user;

import service.impl.AllUserServiceImpl;

public class GuestUser {
	private long userID;
	private static long counter = 0;
	public AllUserServiceImpl service = new AllUserServiceImpl();

	public long getUserID() {
		return userID;
	}

	public void setUserID() {
		userID = counter++;
	}

	public GuestUser() {
		setUserID();
	}
	
	public String toString() {
		return "" + userID;
	}
	
	//TODO: Create service for GuestUser.
}
