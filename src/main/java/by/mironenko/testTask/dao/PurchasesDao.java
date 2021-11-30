package by.mironenko.testTask.dao;

import by.mironenko.testTask.dao.repo.PurchasesRepository;
import by.mironenko.testTask.entity.Purchases;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PurchasesDao {
    private final PurchasesRepository purchasesRepository;

    public List<Purchases> findAll() {
        return StreamSupport
                .stream(purchasesRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Purchases findById(final Long id) {
        return purchasesRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find purchase with id " + id));
    }

    public Purchases save(final Purchases purchases) {
        purchases.setId(null);
        return purchasesRepository.save(purchases);
    }

    public void update(final Purchases purchases) {
        final Purchases existingPurchase = findById(purchases.getId());
        existingPurchase.setUserId(purchases.getUserId());
        existingPurchase.setProductId(purchases.getProductId());
        purchasesRepository.save(existingPurchase);
    }

    public void delete(final Purchases purchases) {
        purchasesRepository.delete(purchases);
    }
}
