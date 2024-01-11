package internshipapp.service.impl;

import internshipapp.persistence.model.InternshipOffer;
import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.Student;
import internshipapp.persistence.repository.InternshipOfferRepository;
import internshipapp.persistence.repository.RecruiterRepository;
import internshipapp.persistence.repository.StudentRepository;
import internshipapp.service.InternshipOfferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InternshipOfferServiceImpl implements InternshipOfferService {
    private final InternshipOfferRepository internshipOfferRepository;
    private final StudentRepository studentRepository;
    private final RecruiterRepository recruiterRepository;

    @Override
    public InternshipOffer saveInternshipOffer(InternshipOffer internshipOffer, Long idRecruiter) {
        Recruiter r = recruiterRepository.findById(idRecruiter).get();
        internshipOffer.setRecruiter(r);
        recruiterRepository.save(r);

        return internshipOfferRepository.save(internshipOffer);
    }

    @Override
    public List<InternshipOffer> getAllInternshipOffers() {
        return internshipOfferRepository.findAll();
    }

    @Override
    public List<InternshipOffer> getAllInternshipOfferForRecruiter(Long id) {
        return internshipOfferRepository.findAll().stream().filter(x->
            x.getRecruiter().getId().equals(id)
        ).collect(Collectors.toList());
    }

    @Override
    public void applyForInternship(InternshipOffer internshipOffer, Long idStudent) {
        Recruiter r = internshipOffer.getRecruiter();
        // Find the student by ID. Use orElseThrow to avoid NullPointerExceptions.
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        // Add the internshipOffer to the student's collection of internshipOffers.
        // This ensures that the relationship is managed on both sides.
        student.getInternshipOffers().add(internshipOffer);

        // Similarly, add the student to the internshipOffer's collection of students.
        internshipOffer.getStudents().add(student);

        // Save the student. Depending on the cascade settings, this may also persist the changes to internshipOffer.
        studentRepository.save(student);

        // It might not be necessary to save the internshipOffer if cascade is properly set up in the Student entity.
        // Otherwise, save the internshipOffer to persist the relationship.
        internshipOfferRepository.save(internshipOffer);
    }

}
