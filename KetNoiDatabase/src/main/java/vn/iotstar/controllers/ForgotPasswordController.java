package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/forgot-password" })
public class ForgotPasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserServiceImpl(); // Khởi tạo userService
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String email = req.getParameter("email");
		String alertMsg = "";

		if (email == null || email.isEmpty()) {
			alertMsg = "Email không được để trống";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra sự tồn tại của email và lấy mật khẩu nếu tồn tại
		String oldPassword = userService.getPasswordByEmail(email);
		if (oldPassword != null) {
			req.setAttribute("oldPassword", oldPassword);
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
		} else {
			alertMsg = "Email không tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
		}
	}

}
