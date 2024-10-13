package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	public ICategoryDao cateDao = new CategoryDaoImpl();
	
	
	@Override
	public List<CategoryModel> findALL() {

		return cateDao.findALL();
	}

	@Override
	public CategoryModel findById(int id) {

		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		
		if(cate != null) {
			cateDao.update(category);
		}
		
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return null;
	}

}
