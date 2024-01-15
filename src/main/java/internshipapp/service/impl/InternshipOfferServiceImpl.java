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
import java.util.List;
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
        Student student = studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.getInternshipOffers().add(internshipOffer);
        internshipOffer.getStudents().add(student);
        studentRepository.save(student);
        internshipOfferRepository.save(internshipOffer);
    }

}