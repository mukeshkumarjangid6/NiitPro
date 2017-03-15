package com.gurgaon.delhi.shoppingBackEnd.daoImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.gurgaon.delhi.shoppingBackEnd.dao.Address1Dao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Address1;

@Repository("Address1DaoImpl")
@Transactional
public class Address1DaoImpl implements Address1Dao {
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	@Override
	public List<Address1> Address1List(int user_id) {
		String selectAddress1 = "FROM Address1 WHERE user_id = :user_id";
		Query query = sessionFactory.getCurrentSession().createQuery(selectAddress1);
		query.setParameter("user_id", user_id);
		return query.getResultList();
	}

	@Override
	public boolean add(Address1 address1) {
		try {
			// add the address to the database
			sessionFactory.getCurrentSession().persist(address1);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean update(Address1 address1) {
		try {
			// update the address1 to the database
			sessionFactory.getCurrentSession().update(address1);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean delete(int address_id, int user_id) {
		List address1List = Address1List(user_id);
		Address1 address1 = (Address1) address1List.get(address_id);
		try {
			// Delete the address1 to the database
			sessionFactory.getCurrentSession().delete(address1);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
