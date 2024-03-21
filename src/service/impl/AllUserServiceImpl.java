package service.impl;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.User;
import service.MainService;

public class AllUserServiceImpl implements IGuestUserService{

	@Override
	public ArrayList<User> findUsers(String keyText) {
		ArrayList<User> foundUsers = new ArrayList<User>();
		for(GuestUser user : MainService.allUsers) {
			if(user instanceof PrivateUser || user instanceof BusinessUser) {
				User regUser = (User) user;
				if(regUser.getNameSurname().toLowerCase().contains(keyText)) {
					foundUsers.add(regUser);
				}
			}
		}
		return foundUsers;
	}

	@Override
	public ArrayList<Page> findPage(String keyText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Post> findPublicPosts(String keyText) {
		// TODO Auto-generated method stub
		return null;
	}

}
