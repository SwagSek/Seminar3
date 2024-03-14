package model;

import java.time.LocalDateTime;

public class Post {
	private String title;
	private String msg;
	private LocalDateTime dateTime = LocalDateTime.now();
	//TODO convert to User list.
	private int countOfLikes = 0;
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	//Setters
	public void setTitle(String title) {
		if (title != null && title.length() > 5 && title.length() < 50)
			this.title = title;
		else
			this.title = "Undefined";
	}
	
	public void setMsg(String msg) {
		if (msg != null && msg.length() > 0 && msg.length() < 1000)
			this.msg = msg;
		else
			this.msg = "Undefined";
	}
	
	//Could change if int is changed to User list.
	public void incrementCountOfLikes() {
		countOfLikes++;
	}

	//Constructors
	public Post() {
		setTitle("Undefined");
		setMsg("Undefined");
	}

	public Post(String title, String msg) {
		setTitle(title);
		setMsg(msg);
	}

	public String toString() {
		return title + "(" + dateTime + ") \n" + msg + "\n[ " + countOfLikes + " ]\n\n"; 
	}
}
