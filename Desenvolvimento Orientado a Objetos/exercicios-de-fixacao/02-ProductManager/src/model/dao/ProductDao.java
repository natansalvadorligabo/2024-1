package model.dao;

import java.util.List;

import model.entity.Product;

public interface ProductDao {
    
    List<Product> findAllProducts();

    Product findById(int id);

    boolean insert(Product product);

    boolean delete(int id);

    boolean update(int id, Product product);
}
