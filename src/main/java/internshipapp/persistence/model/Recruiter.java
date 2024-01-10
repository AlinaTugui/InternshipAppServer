package internshipapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "recruiters")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private String phoneNumber;
    private String companyName;

    //OneToMany with InternshipOffer
    @OneToMany(mappedBy = "recruiter")
    private Set<InternshipOffer> internshipOffers;
}
