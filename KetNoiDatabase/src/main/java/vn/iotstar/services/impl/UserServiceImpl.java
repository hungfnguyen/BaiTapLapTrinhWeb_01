package vn.iotstar.services.impl;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {
	
	 private UserDaoImpl userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username) {
		// Gọi phương thức của DAO để tìm người dùng

		return userDao.findByUserName(username);
	}

	@Override
	public UserModel get(String username) {
		return this.findByUserName(username);
	}
	
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}

	@Override
	public boolean register(String username, String email,String fullname, String images, String password) {
		// Kiểm tra xem username đã tồn tại hay chưa
	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }
	    
	    if (userDao.checkExistEmail(email)) {
	        return false;
	    }
	    
	    UserModel newUser = new UserModel(0, username, email, fullname,  images, password);
	    userDao.insert(newUser);

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

	

	

}
