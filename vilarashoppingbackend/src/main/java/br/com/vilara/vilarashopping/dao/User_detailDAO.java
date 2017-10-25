package br.com.vilara.vilarashopping.dao;

import java.util.List;

import br.com.vilara.vilarashopping.dto.Product;
import br.com.vilara.vilarashopping.dto.User_detail;

public interface User_detailDAO {
	
	User_detail get(int userDetailId);
	List<User_detail> list();
	boolean add(User_detail userDetail);
	boolean update(User_detail userDetailt);
	boolean delete(User_detail userDetail);

}
