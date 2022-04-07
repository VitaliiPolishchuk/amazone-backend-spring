package the.best.amazonclonebackend.service;

import the.best.amazonclonebackend.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    Collection<List<Product>> list(int limit);
}
