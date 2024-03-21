package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Page;
import model.PostType;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;

public class MainService {
	
	private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

	public static void main(String[] args) {
		GuestUser gU1 = new GuestUser();
		GuestUser gU2 = new GuestUser();
		GuestUser gU3 = new GuestUser();
		PrivateUser pU1 = new PrivateUser("Elvijs Leistmanis", "asdf123");
		BusinessUser bu1 = new BusinessUser();
		BusinessUser bu2 = new BusinessUser("LV40003666476", "SIA Hesburger", "qwerty");
		
		allUsers.addAll(Arrays.asList(gU1, gU2, gU3, pU1, bu1, bu2));
		
		for(GuestUser tempUser : allUsers) {
			System.out.println(tempUser);
		}
		System.out.println("------------------------");
		
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
		
		System.out.println("-------------------------------");
		try {
			bu2.addPage("Hesburgers Ventspils", "Aktualitates par Ventspils filiali");
			bu2.addPage("Hesburgers Daugavpils", "Aktualitates par Daugavpils filiali");
			bu2.addPage("Hesburgers Ainazi", "Aktualitates par Ainazu filiali");
			
			bu2.publishPostInPage("Jaunumi marta", "okay", "Hesburgers Ventspils", PostType.publicPost);
			bu2.publishPostInPage("Jaunumi februari", "okay2", "Hesburgers Daugavpils", PostType.publicPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Page page : bu2.getPageList()) {
			System.out.println("Page: " + page);
			System.out.println("Private Posts: " + page.getPrivatePosts());
			System.out.println("Public Posts: " + page.getPublicPosts());
		}
	}

}
