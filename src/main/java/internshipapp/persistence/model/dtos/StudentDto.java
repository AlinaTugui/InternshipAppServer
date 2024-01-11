package internshipapp.persistence.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String university;
    private String faculty;
    private String section;
    private String email;
    private String password;
    private String description;
    private Date birthDate;
    private String address;
    private Boolean prevExperience;

}
