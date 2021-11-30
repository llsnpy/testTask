package by.mironenko.testTask.service;

import by.mironenko.testTask.dao.AdminDao;
import by.mironenko.testTask.dto.AdminDto;
import by.mironenko.testTask.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


//todo допилить функциональные команды (удаление апдейт создание товаров)
@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminDao adminDao;

    public List<AdminDto> getAll() {
        return adminDao.findAll()
                .stream()
                .map(AdminDto::new)
                .collect(Collectors.toList());
    }

    public AdminDto getById(final Long id) {
        return new AdminDto(adminDao.findById(id));
    }

    @Transactional
    public Long save(final AdminDto adminDto) {
        return adminDao.save(new Admin(adminDto)).getId();
    }

    public void update(final AdminDto adminDto) {
        adminDao.update(new Admin(adminDto));
    }

    public void deleteById(final Long id) {
        adminDao.delete(adminDao.findById(id));
    }
}
