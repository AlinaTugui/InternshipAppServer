package internshipapp.service;

import internshipapp.persistence.model.InternshipOffer;
import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.Student;

import java.util.List;

public interface InternshipOfferService {
    InternshipOffer saveInternshipOffer(InternshipOffer internshipOffer, Recruiter recruiter);

    List<InternshipOffer> getAllInternshipOffers();

    List<InternshipOffer> getAllInternshipOfferForRecruiter(Long id);

    void applyForInternship(InternshipOffer internshipOffer, Student student);
}
