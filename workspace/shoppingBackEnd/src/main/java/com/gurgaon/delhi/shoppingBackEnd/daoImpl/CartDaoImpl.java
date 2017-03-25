package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gurgaon.delhi.shoppingBackEnd.dao.CartDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;

@Repository("CartDaoImpl")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public Cart getCartBycart_Id(int cart_Id) {
		String selectCartId = "FROM Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(selectCartId, Cart.class);
		query.setParameter("parameter", cart_Id);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	/*
	 * Delete all cart items of a user.
	 */
	@Override
	public boolean deleteAllCartItems(Cart cart) {
		try {
			String selectCartId = "DELETE FROM CartItem WHERE cart=:parameter";
			Query query = sessionFactory.getCurrentSession().createQuery(selectCartId);
			query.setParameter("parameter", cart);
			System.out.println(query.executeUpdate());
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}

	}
}