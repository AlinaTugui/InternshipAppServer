package internshipapp.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "students")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    //ManyToMany with InternshipOffer
    @ManyToMany(mappedBy = "students")
    private Set<InternshipOffer> internshipOffers;
}
