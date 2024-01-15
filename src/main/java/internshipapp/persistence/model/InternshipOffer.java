package internshipapp.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "internship_offers")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class InternshipOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String type;
    private String description;
    private String domain;
    private Boolean paid;

    //ManyToOne with Recruiter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    //ManyToMany with Student
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "student_internship_offer",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "internship_offer_id"))
    private Set<Student> students;

}
