package vn.iotstar.dao.impl;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.impl.UserServiceImpl;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {

		String sql = "SELECT * FROM users";

		List<UserModel> list = new ArrayList<>(); // tạo 1 list để truyền dữ liệu

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) { // next từng hàng tới cuối bảng
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("images"), rs.getString("password")));

			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UserModel findByUsernameAndPassword(String username, String password) {
	    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

	    try {
	        conn = super.getDatabaseConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
	                    rs.getString("fullname"), rs.getString("images"), rs.getString("password"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	
	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";

		try {
			// ket noi database
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			// executeUpdate() là dùng cho các câu lệnh INSERT, UPDATE, hoặc DELETE.
			// ps.executeUpdate();

			// executeQuery() là phương thức để thực thi câu lệnh SELECT
			rs = ps.executeQuery();

			if (rs.next()) {
				return new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("images"), rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(id, username, email, fullname, images, password)" + " VALUES(?, ?, ?, ?, ?, ?)";

		try {
			conn = super.getDatabaseConnection(); // ket noi database
			ps = conn.prepareStatement(sql); // nem cau lenh sql vao de thuc thi

			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getPassword());

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";

	    try {
	        conn = super.getDatabaseConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
	                    rs.getString("fullname"), rs.getString("images"), rs.getString("password"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
	    String query = "SELECT * FROM users WHERE email = ?";

	    try {
	        // Kết nối cơ sở dữ liệu
	        conn = super.getDatabaseConnection(); 
	        ps = conn.prepareStatement(query);
	        ps.setString(1, email);

	        // Thực thi câu truy vấn
	        rs = ps.executeQuery();
	        
	        // Kiểm tra xem có kết quả trả về hay không
	        if (rs.next()) {
	            duplicate = true;
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace(); // Xử lý lỗi, in thông tin lỗi ra
	    } finally {
	        // Đảm bảo đóng tài nguyên sau khi sử dụng
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
	    String query = "SELECT * FROM users WHERE username = ?";

	    try {
	        // Kết nối đến cơ sở dữ liệu
	        conn = super.getDatabaseConnection(); 
	        ps = conn.prepareStatement(query);
	        ps.setString(1, username);

	        // Thực thi câu truy vấn
	        rs = ps.executeQuery();

	        // Kiểm tra xem có kết quả trả về hay không
	        if (rs.next()) {
	            duplicate = true;
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace(); // In ra thông tin lỗi nếu có
	    } finally {
	        // Đảm bảo đóng tài nguyên sau khi sử dụng
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace(); // In lỗi khi đóng tài nguyên
	        }
	    }

	    return duplicate;
	}
	
	public static void main(String[] args) {
	    UserServiceImpl userService = new UserServiceImpl();
	    
	    // Thay vì gọi insert, bạn nên gọi hàm register để kiểm tra username/email trùng lặp
	    boolean isRegistered = userService.register("tanhung", "tanhung@gmail.com", "mai hong hai", null, "123");
	    
	    if (isRegistered) {
	        System.out.println("Đăng ký thành công!");
	    } else {
	        System.out.println("Username hoặc Email đã tồn tại.");
	    }

	    // Hiển thị danh sách người dùng
	    UserDaoImpl userDaoImpl = new UserDaoImpl();
	    List<UserModel> list = userDaoImpl.findAll();

	    for (UserModel userModel : list) {
	        System.out.println(userModel);
	    }
	}
	
}
