package by.mironenko.testTask.entity;

import by.mironenko.testTask.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    public User(final UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.surname = userDto.getSurname();
    }
}
