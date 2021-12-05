package by.mironenko.testTask.controller;

import by.mironenko.testTask.dto.UserDto;
import by.mironenko.testTask.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{users_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@NonNull @PathVariable("users_id") Long id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@NonNull @PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
