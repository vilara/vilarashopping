package br.com.vilara.vilarashopping.daoimpl;

import java.util.List;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;

@Repository("user_detailDAO")
@Transactional
public class User_detailDAOImpl implements User_detailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User_detail user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {

		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public User_detail getByEmail(String email) {
		String selectQuery = "FROM User_detail WHERE email = :email";
		try {
			
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User_detail.class)
						.setParameter("email", email)
							.getSingleResult();
			
		} catch (Exception e) {
			//e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public Address getBillingsAddress(User_detail user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try {
			return
			sessionFactory.getCurrentSession()
				.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
						.setParameter("billing", true)
							.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public List<Address> listshippingAddresses(User_detail user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			return
			sessionFactory.getCurrentSession()
				.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
						.setParameter("shipping", true)
							.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}

}
