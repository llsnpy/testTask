package by.mironenko.testTask.dao;

import by.mironenko.testTask.dao.repo.ProductRepository;
import by.mironenko.testTask.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductDao {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return StreamSupport
                .stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Product findById(final Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find product with id " + id));
    }

    public Product save(final Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public void update(final Product product) {
        final Product existingProduct = findById(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        productRepository.save(existingProduct);
    }

    public void delete(final Product product) {
        productRepository.delete(product);
    }
}
