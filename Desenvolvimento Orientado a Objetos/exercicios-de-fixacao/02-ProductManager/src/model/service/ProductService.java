package model.service;

import java.util.List;

import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.entity.Product;

public class ProductService {

    private ProductDao dao;

    public boolean save(Product product){
        if(product != null){
            dao.insert(product);
            return true;
        }
        return false;
    }

    public ProductService() {
        dao = ProductDaoImpl.getInstance();
    }

    public List<Product> getAllProducts() {
        return dao.findAllProducts();
    }
}
