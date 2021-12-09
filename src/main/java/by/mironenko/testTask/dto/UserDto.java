package by.mironenko.testTask.dto;

import by.mironenko.testTask.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;


    public UserDto(final User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
