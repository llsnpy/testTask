package by.mironenko.testTask.dao.repo;

import by.mironenko.testTask.entity.Purchases;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends CrudRepository<Purchases, Long> {
}
