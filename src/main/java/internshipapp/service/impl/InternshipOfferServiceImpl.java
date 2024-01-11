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
    public InternshipOffer saveInternshipOffer(InternshipOffer internshipOffer, Recruiter recruiter) {
        internshipOffer.setRecruiter(recruiter);
        recruiterRepository.save(recruiter);

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
    public void applyForInternship(InternshipOffer internshipOffer, Student student) {
        Set<Student> students = new HashSet<>();
        students.add(student);
        internshipOffer.setStudents(students);

        Set<InternshipOffer> internshipOffers = new HashSet<>();
        internshipOffers.add(internshipOffer);
        student.setInternshipOffers(internshipOffers);
        studentRepository.save(student);
    }
}
