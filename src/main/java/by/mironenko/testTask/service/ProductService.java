package by.mironenko.testTask.service;

import by.mironenko.testTask.dao.ProductDao;
import by.mironenko.testTask.dto.ProductDto;
import by.mironenko.testTask.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<ProductDto> getAll() {
        return productDao.findAll()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    public ProductDto getById(final Long id) {
        return new ProductDto(productDao.findById(id));
    }

    @Transactional
    public Long save(final ProductDto productDto) {
        return productDao.save(new Product(productDto)).getId();
    }

    public void update(final ProductDto productDto) {
        productDao.update(new Product(productDto));
    }

    public void deleteById(final Long id) {
        productDao.delete(productDao.findById(id));
    }
}
