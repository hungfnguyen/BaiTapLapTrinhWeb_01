package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface UserService {
	UserModel login(String username);
	
	UserModel get(String username);
	void insert(UserModel user);
	boolean register(String username, String email,String fullname, String images, String password);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	
}
