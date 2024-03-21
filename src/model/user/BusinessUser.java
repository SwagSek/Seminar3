package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User{
	private String VATNo;
	private ArrayList<Page> pageList = new ArrayList<Page>();
	
	public String getVATNo() {
		return VATNo;
	}

	public ArrayList<Page> getPageList() {
		return pageList;
	}

	public void setVATNo(String VATNo) {
		if (VATNo != null && VATNo.matches("[A-Z]{2}[0-9]{11}"))
			this.VATNo = VATNo;
		else
			this.VATNo = "LV00000000000";
	}
	
	@Override
	public void setNameSurname(String nameSurname) {
		if (nameSurname != null && nameSurname.matches("[A-Za-z0-9.,:@&%+= ]{2,40}"))
			super.nameSurname = nameSurname;
		else
			super.nameSurname = "Undefined";
	}

	public BusinessUser() {
		super();
		setNameSurname("Undefined");
		setUsername();
		setVATNo("LV00000000000");
	}
	
	public BusinessUser(String VATNo, String nameSurname, String password) {
		super(password);
		setNameSurname(nameSurname);
		setUsername();
		setVATNo(VATNo);
	}
	
	public String toString () {
		return super.toString() + "[" + VATNo + "]";
	}
	
	public void addPage(String title, String description) throws Exception {
		//TODO: If necessary, check if not null
		for(Page tempPage : pageList) {
			if(tempPage.getTitle().toLowerCase().equals(title.toLowerCase()))
				throw new Exception("Page already exists.");
		}
		
		Page newPage = new Page(title, description);
		pageList.add(newPage);
	}
	
	public void publishPostInPage(String postTitle, String msg, String pageTitle, PostType type) throws Exception {
		//TODO: If necessary, check if not null
		for (Page page : pageList) {
			if (page.getTitle().toLowerCase().equals(pageTitle.toLowerCase())) {
				Post newPost = publishPost(postTitle, msg, type);
				if(type.equals(PostType.privatePost))
					page.getPrivatePosts().add(newPost);
				else if (type.equals(PostType.publicPost))
					page.getPublicPosts().add(newPost);
				return;
			}
		}
		throw new Exception("Page not found");
	}

	@Override
	public Post publishPost(String title, String msg, PostType type) throws Exception {
		Post newPost = new Post(title, msg);
		return newPost;
		
	}
}
