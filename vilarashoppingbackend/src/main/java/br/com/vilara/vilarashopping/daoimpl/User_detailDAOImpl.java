package br.com.vilara.vilarashopping.daoimpl;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Address;
import br.com.vilara.vilarashopping.dto.Cart;
import br.com.vilara.vilarashopping.dto.User_detail;

@Repository("User_detailDAO")
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
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
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
			e.printStackTrace();
			
			return null;
		}
	}

}
