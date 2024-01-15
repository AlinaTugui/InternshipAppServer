package internshipapp.service;

import internshipapp.persistence.model.InternshipOffer;
import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.Student;

import java.util.List;

public interface InternshipOfferService {
    InternshipOffer saveInternshipOffer(InternshipOffer internshipOffer, Long idRecruiter);

    List<InternshipOffer> getAllInternshipOffers();

    List<InternshipOffer> getAllInternshipOfferForRecruiter(Long id);

    void applyForInternship(Long idInternship, Long idStudent);
}