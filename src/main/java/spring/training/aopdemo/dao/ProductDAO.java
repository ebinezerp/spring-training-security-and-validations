package spring.training.aopdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.training.aopdemo.model.Product;

@Repository("productDao")
public interface ProductDAO {

	public boolean addProduct(Product product);

	public Product getProduct(Integer id);

	public Product getProduct(String name);

	public List<Product> getProduct();
}
