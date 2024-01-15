package internshipapp.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class InternshipRequest {
    private Long idInternship;
    private Long idUser;
}
