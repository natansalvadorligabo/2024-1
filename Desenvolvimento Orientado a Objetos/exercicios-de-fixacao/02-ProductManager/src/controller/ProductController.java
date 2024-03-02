package controller;

import java.util.ArrayList;
import java.util.List;

import dto.ProductDto;
import model.entity.Product;
import model.service.ProductService;

public class ProductController {
    
    private ProductService service = null;

    public ProductController() {
        service = new ProductService();
    }

    public boolean add(ProductDto productDto){
        var product = productDto.toDomain();

        return service.save(product);
    }

    public boolean delete(int id) {
        for (Product product : service.getAllProducts()) {
            if (product.getId() == id) {
                service.remove(id);
                return true;
            }
        }
        return false;
    }

    public boolean update(int id, ProductDto updatedProduct) {
        for(Product p : service.getAllProducts()){
            if (p.getId() == id){
                p.setName(updatedProduct.getName());
                p.setDescription(updatedProduct.getDescription());
                p.setPrice(updatedProduct.getPrice());
                p.setStockQuantity(updatedProduct.getStockQuantity());
                return true;
            }
        }
        return false;
    }

    public boolean findById(int id) {
        for (Product p : service.getAllProducts()) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> list = new ArrayList<>();
        for (Product product : service.getAllProducts()) {
            list.add(new ProductDto(product));
        }
        return list;
    }
}
