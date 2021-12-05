package by.mironenko.testTask.service;

import by.mironenko.testTask.dao.AdminDao;
import by.mironenko.testTask.dto.PuechasesDto;
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

    public List<PuechasesDto> getAll() {
        return adminDao.findAll()
                .stream()
                .map(PuechasesDto::new)
                .collect(Collectors.toList());
    }

    public PuechasesDto getById(final Long id) {
        return new PuechasesDto(adminDao.findById(id));
    }

    @Transactional
    public Long save(final PuechasesDto adminDto) {
        return adminDao.save(new Admin(adminDto)).getId();
    }

    public void update(final PuechasesDto adminDto) {
        adminDao.update(new Admin(adminDto));
    }

    public void deleteById(final Long id) {
        adminDao.delete(adminDao.findById(id));
    }
}
