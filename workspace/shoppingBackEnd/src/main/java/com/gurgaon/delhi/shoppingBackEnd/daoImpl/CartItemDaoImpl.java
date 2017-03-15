package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gurgaon.delhi.shoppingBackEnd.dao.CartItemDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Cart;
import com.gurgaon.delhi.shoppingBackEnd.dto.CartItem;

@Repository("CartItemDaoImpl")
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public CartItem getCartItemByCartItem_Id(int cartItem_Id) {
		String selectCartId = "FROM CartItem where cartItem_Id=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId, CartItem.class);
		query.setParameter("parameter", cartItem_Id);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<CartItem> cartItemGetByCart(Cart cart) {
		String selectCartId = "FROM CartItem where cart=:parameter";
		Query<CartItem> query = sessionFactory.getCurrentSession().createQuery(selectCartId);
		query.setParameter("parameter", cart);
		try {
			return query.getResultList();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}
	
	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			// update the User to the database
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(int cartItem_Id) {
		CartItem cartItem = getCartItemByCartItem_Id(cartItem_Id);
		try {
			// Delete the User to the database
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}