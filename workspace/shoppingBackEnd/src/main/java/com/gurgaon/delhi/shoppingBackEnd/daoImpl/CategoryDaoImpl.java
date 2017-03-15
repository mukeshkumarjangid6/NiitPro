package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurgaon.delhi.shoppingBackEnd.dao.CategoryDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Category;

@Repository("CategoryDaoImpl")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active_is = :active_is";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active_is", true);
		return query.getResultList();
	}

	// Getting Single Category on id
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	public boolean add(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		try {
			// update the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {
		category.setActive(false);
		try {
			// Delete the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}