package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import static vn.iotstar.utils.Constant.*;

@WebServlet(urlPatterns = {"/admin/categories",
		"/admin/category/add",
		"/admin/category/insert",
		"/admin/category/edit",
		"/admin/category/update",
		"/admin/category/delete",
		"/admin/category/search"})
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -914191179471374359L;
	public ICategoryService cateService =  new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if(url.contains("categories")) {
			List<CategoryModel> list = cateService.findALL();
			
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		else if(url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}
		else if(url.contains("edit")){
			int id = Integer.parseInt(req.getParameter("id"));
			
			CategoryModel category = cateService.findById(id);
			
			req.setAttribute("cate", category);
			
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
		else if(url.contains("delete")) {
			String id = req.getParameter("id");
			cateService.delete(Integer.parseInt(id));
			resp.sendRedirect(req.getContextPath() + "/admin/categories" );
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if(url.contains("insert")) {
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(statuss);
			
			String fname ="";
			String uploadPath = DIR;
			
			category.setImages(fname);
			
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
		else if (url.contains("update")){
			
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			String status = req.getParameter("status");
			int statuss = Integer.parseInt(status);
			String images = "https://thongsokythuat.vn/wp-content/uploads/Dien-thoai-Google-Pixel-6-Pro-5G-2021-600x600.jpg";
			
			CategoryModel category = new CategoryModel();
			
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setImages(images);
			category.setStatus(statuss);
			
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
			
		}
	}
}
