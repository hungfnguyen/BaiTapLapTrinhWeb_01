package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);

	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	
	// Thêm phương thức để lấy mật khẩu theo email
    String getPasswordByEmail(String email);
	/*
	 * UserModel get(String username); void insert(UserModel user);
	 */
	/*
	 * boolean register(String username, String email,String fullname, String
	 * images, String password); boolean checkExistEmail(String email); boolean
	 * checkExistUsername(String username);
	 */

}
