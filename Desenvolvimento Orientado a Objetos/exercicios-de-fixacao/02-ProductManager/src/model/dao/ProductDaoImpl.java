package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.Product;

public class ProductDaoImpl implements ProductDao {

    private static ProductDaoImpl instance = null;
    private List<Product> productList;

    private ProductDaoImpl() {
        productList = new ArrayList<>();
    }

    public static synchronized ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Product> findAllProducts() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean insert(Product product) {
        if (product != null) {
            if (findById(product.getId()) == null) {
                productList.add(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        int index = 0;
        for(Product p : productList){
            if (p.getId() == id){
                productList.set(index, product);
                return true;
            }
            index++;
        }
        return false;
    }
}
