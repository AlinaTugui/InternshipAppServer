package internshipapp.persistence.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private String phoneNumber;
    private String companyName;
}
