package br.com.vilara.vilarashopping.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vilara.vilarashopping.dao.User_detailDAO;
import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.dto.User_detail;

@Repository("UserDetailDAO")
@Transactional
public class User_detailDAOImpl implements User_detailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public User_detail get(int userDetailId) {
		try {
			return sessionFactory.getCurrentSession().get(User_detail.class, Integer.valueOf(userDetailId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User_detail> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM User_detail", User_detail.class).getResultList();
	}

	@Override
	public boolean add(User_detail userDetail) {
		try {
			sessionFactory.getCurrentSession().persist(userDetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User_detail userDetailt) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(userDetailt);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User_detail userDetail) {
		try {
			userDetail.setEnabled(false);
			return this.update(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
