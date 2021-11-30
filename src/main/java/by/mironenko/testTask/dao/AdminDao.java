package by.mironenko.testTask.dao;

import by.mironenko.testTask.dao.repo.AdminRepository;
import by.mironenko.testTask.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AdminDao {
    private final AdminRepository adminRepository;

    public List<Admin> findAll() {
        return StreamSupport
                .stream(adminRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Admin findById(final Long id) {
        return adminRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Can't ding admin with id " + id));
    }

    public Admin save(final Admin admin) {
        admin.setId(null);
        return adminRepository.save(admin);
    }

    public void update(final Admin admin) {
        final Admin existingAdmin = findById(admin.getId());
        existingAdmin.setName(admin.getName());
        existingAdmin.setSurname(admin.getSurname());
        adminRepository.save(existingAdmin);
    }

    public void delete(final Admin admin) {
        adminRepository.delete(admin);
    }
}
