package by.mironenko.testTask.controller;

import by.mironenko.testTask.dto.PuechasesDto;
import by.mironenko.testTask.service.AdminService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admins", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    private final AdminService adminService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PuechasesDto> getAllAdmins() {
        return adminService.getAll();
    }

    @RequestMapping(value = "/{admins_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PuechasesDto getAdminById(@NonNull @PathVariable("admins_id") Long id) {
        return adminService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAdmin(@RequestBody PuechasesDto adminDto) {
        return adminService.save(adminDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAdmin(@RequestBody PuechasesDto adminDto) {
        adminService.update(adminDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@NonNull @PathVariable("id") Long id) {
        adminService.deleteById(id);
    }
}
