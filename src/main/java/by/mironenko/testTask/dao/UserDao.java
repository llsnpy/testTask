package by.mironenko.testTask.dao;

import by.mironenko.testTask.dao.repo.UserRepository;
import by.mironenko.testTask.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserDao {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User findById(final Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find user with id " + id));
    }

    public User save(final User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    public void update(final User user) {
        final User existingUser = findById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getName());
        userRepository.save(existingUser);
    }

    public void delete(final User user) {
        userRepository.delete(user);
    }
}
