package by.mironenko.testTask.service;

import by.mironenko.testTask.dao.PurchasesDao;
import by.mironenko.testTask.dto.PurchasesDto;
import by.mironenko.testTask.entity.Purchases;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchasesService {
    private final PurchasesDao purchasesDao;

    public List<PurchasesDto> getAll() {
        return purchasesDao.findAll()
                .stream()
                .map(PurchasesDto::new)
                .collect(Collectors.toList());
    }

    public PurchasesDto getById(final Long id) {
        return new PurchasesDto(purchasesDao.findById(id));
    }

    @Transactional
    public Long save(final PurchasesDto purchasesDto) {
        return purchasesDao.save(new Purchases(purchasesDto)).getId();
    }

    public void update(final PurchasesDto purchasesDto) {
        purchasesDao.update(new Purchases(purchasesDto));
    }

    public void deleteById(final Long id) {
        purchasesDao.delete(purchasesDao.findById(id));
    }
}
