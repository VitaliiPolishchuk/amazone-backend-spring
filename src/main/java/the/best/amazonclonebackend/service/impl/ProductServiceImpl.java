package the.best.amazonclonebackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import the.best.amazonclonebackend.model.Product;
import the.best.amazonclonebackend.repository.ProductRepository;
import the.best.amazonclonebackend.service.ProductService;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Collection<List<Product>> list(int limit) {
        return productRepository.findAll()
                .stream()
                .map(product -> new AbstractMap.SimpleEntry<>(product.getWidth(), product))
                .collect(Collectors.groupingBy(e -> e.getKey(),
                        Collectors.mapping(e -> e.getValue(), Collectors.toList())))
                .values();

    }
}