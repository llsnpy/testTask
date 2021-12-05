package by.mironenko.testTask.service;

import by.mironenko.testTask.dao.UserDao;
import by.mironenko.testTask.dto.UserDto;
import by.mironenko.testTask.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public List<UserDto> getAll() {
        return userDao.findAll()
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public UserDto getById(final Long id) {
        return new UserDto(userDao.findById(id));
    }

    @Transactional
    public Long save(final UserDto userDto) {
        return userDao.save(new User(userDto)).getId();
    }

    public void update(final UserDto userDto) {
        userDao.update(new User(userDto));
    }

    public void deleteById(final Long id) {
        userDao.delete(userDao.findById(id));
    }
}
