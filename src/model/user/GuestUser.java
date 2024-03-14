package model.user;

public class GuestUser {
	private long userID;
	private static long counter = 0;

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
}
