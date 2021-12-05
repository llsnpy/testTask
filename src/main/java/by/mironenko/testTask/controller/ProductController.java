package by.mironenko.testTask.controller;

import by.mironenko.testTask.dto.ProductDto;
import by.mironenko.testTask.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/{products_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProductById(@NonNull @PathVariable("products_id") Long id) {
        return productService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProduct(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.update(productDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@NonNull @PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
