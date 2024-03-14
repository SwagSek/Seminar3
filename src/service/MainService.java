package service;

import model.PostType;
import model.user.GuestUser;
import model.user.PrivateUser;

public class MainService {

	public static void main(String[] args) {
		GuestUser gU1 = new GuestUser();
		GuestUser gU2 = new GuestUser();
		GuestUser gU3 = new GuestUser();
		PrivateUser pU1 = new PrivateUser("Elvijs Leistmanis", "asdf123");
		
		try {
			pU1.publishPost("Test22", "This is a test Message.", PostType.publicPost);
			pU1.publishPost("Test23", "This is a test Message too.", PostType.privatePost);
			pU1.publishPost("Test35", "This is a test Message, again.", PostType.publicPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(gU1);
		System.out.println(pU1);
		
		System.out.println(pU1.getPrivatePosts());
		System.out.println(pU1.getPublicPosts());
	}

}
