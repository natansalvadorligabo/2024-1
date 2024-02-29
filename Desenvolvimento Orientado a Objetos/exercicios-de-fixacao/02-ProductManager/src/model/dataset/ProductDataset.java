package model.dataset;

import java.util.ArrayList;
import java.util.List;

import model.entity.Product;

public class ProductDataset {
    
    private static ProductDataset instance = null;
    private List<Product> dataset;

    private ProductDataset() {
        dataset = new ArrayList<>();
    }

    public static synchronized ProductDataset getInstance() {
        if (instance == null) {
            instance = new ProductDataset();
        }
        return instance;
    }

    public boolean addProduct(Product product) {
        return this.dataset.remove(product);
    }

    public boolean deleteProduct(Product product) {
        return dataset.remove(product);
    }

    public Product getProduct(int id){
        for (Product product : dataset) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
