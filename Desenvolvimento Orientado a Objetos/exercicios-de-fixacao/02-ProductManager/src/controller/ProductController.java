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
        var movie = productDto.toDomain();
        return service.save(movie);
    }

    public boolean delete(int id) {
        for (Product product : service.getAllProducts()) {
            if (product.getId() == id) {
                service.getAllProducts().remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean update(int id, ProductDto product) {
        int index = 0;
        for(Product p : service.getAllProducts()){
            if (p.getId() == id){
                service.getAllProducts().set(index, p);
                return true;
            }
            index++;
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
