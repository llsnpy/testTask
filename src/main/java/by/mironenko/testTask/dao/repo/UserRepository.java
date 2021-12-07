package by.mironenko.testTask.dao.repo;

import by.mironenko.testTask.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
