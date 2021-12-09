package by.mironenko.testTask.dto;

import by.mironenko.testTask.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Long id;
    private String name;
    private String surname;

    public AdminDto(final Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.surname = admin.getSurname();
    }
}
