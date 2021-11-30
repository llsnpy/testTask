package by.mironenko.testTask.dto;

import by.mironenko.testTask.entity.Purchases;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchasesDto {
    private Long id;
    private Long userId;
    private Long productId;

    public PurchasesDto(final Purchases purchases) {
        this.id = purchases.getId();
        this.userId = purchases.getUserId();
        this.productId = purchases.getProductId();
    }
}
