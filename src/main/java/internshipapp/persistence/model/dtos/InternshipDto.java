package internshipapp.persistence.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class InternshipDto {
    private Long id;
    private String city;
    private String type;
    private String description;
    private String domain;
    private Boolean paid;
    private Long idUser;
}
