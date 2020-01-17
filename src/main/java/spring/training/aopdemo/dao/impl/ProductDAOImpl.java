package spring.training.aopdemo.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.training.aopdemo.dao.ProductDAO;
import spring.training.aopdemo.model.Product;

@Service
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}

	}

	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProduct(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
