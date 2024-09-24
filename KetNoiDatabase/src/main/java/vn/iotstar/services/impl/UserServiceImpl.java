package vn.iotstar.services.impl;

import java.awt.Image;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {

	private UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findByUserName(username);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	/*
	 * public UserModel get(String username) { return this.findByUserName(username);
	 * }
	 */

	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel(username, email, password, fullname, null, 1, phone, date));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public String getPasswordByEmail(String email) {
		UserModel user = userDao.FindByEmail(email);
        if (user != null) {
            return user.getPassword();
        }
        return null;
	}

	/*
	 * @Override public void insert(UserModel user) { userDao.insert(user);
	 * 
	 * }
	 */

	/*
	 * @Override public boolean register(String username, String email,String
	 * fullname, String images, String password) { // Kiểm tra xem username đã tồn
	 * tại hay chưa if (userDao.checkExistUsername(username)) { return false; }
	 * 
	 * if (userDao.checkExistEmail(email)) { return false; }
	 * 
	 * UserModel newUser = new UserModel(0, username, email, fullname, images,
	 * password); userDao.insert(newUser);
	 * 
	 * return true; }
	 * 
	 * @Override public boolean checkExistEmail(String email) { return
	 * userDao.checkExistEmail(email); }
	 * 
	 * @Override public boolean checkExistUsername(String username) { return
	 * userDao.checkExistUsername(username); }
	 */

}
