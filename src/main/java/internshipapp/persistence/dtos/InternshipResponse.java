package internshipapp.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InternshipResponse {
    private Long id;
    private String city;
    private String type;
    private String description;
    private String domain;
    private Boolean paid;
    private String recruiterFirstName;
    private String recruiterLastName;
    private String email;
    private String phoneNumber;
    private String companyName;
}
