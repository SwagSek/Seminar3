package service.impl;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.User;

public interface IGuestUserService {
	public ArrayList<User> findUsers(String keyText);
	public ArrayList<Page> findPage(String keyText);
	public ArrayList<Post> findPublicPosts(String keyText);
}
