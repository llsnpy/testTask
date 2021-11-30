package by.mironenko.testTask.entity;

import by.mironenko.testTask.dto.AdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "admins")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    public Admin(final AdminDto adminDto) {
        this.id = adminDto.getId();
        this.name = adminDto.getName();
        this.surname = adminDto.getSurname();
    }
}
