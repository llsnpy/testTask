package by.mironenko.testTask.entity;

import by.mironenko.testTask.dto.PurchasesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchases")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long productId;

    public Purchases(final PurchasesDto purchasesDto) {
        this.id = purchasesDto.getId();
        this.userId = purchasesDto.getUserId();
        this.productId = purchasesDto.getProductId();
    }
}
