package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurgaon.delhi.shoppingBackEnd.dao.UserDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.User;

@Repository("UserDaoImpl")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public User getUserByUsername(String email) {
		String selectUserId = "FROM User where email=:parameter";
		Query<User> query = sessionFactory.getCurrentSession().createQuery(selectUserId, User.class);
		query.setParameter("parameter", email);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
		// return sessionFactory.getCurrentSession().get(User.class,
		// email); This line execute on primary key not on others
	}

	@Override
	public User getUserById(int user_id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(user_id));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(User user) {
		try {
			// Mapping OneToOne
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			// add the User to the database
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean update(User user) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean delete(String email) {
		User user = getUserByUsername(email);
		user.setEnabled(false);
		try {
			// Delete the User to the database
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}