package by.mironenko.testTask.entity;

import by.mironenko.testTask.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String category;

    public Product(ProductDto productDto) {
        this.id = productDto.getId();
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.category = productDto.getCategory();
    }
}
