package internshipapp.service;

import internshipapp.persistence.model.InternshipOffer;

import java.util.List;

public interface InternshipOfferService {
    InternshipOffer saveInternshipOffer(InternshipOffer internshipOffer, Long idRecruiter);

    List<InternshipOffer> getAllInternshipOffers();

    List<InternshipOffer> getAllInternshipOfferForRecruiter(Long id);

    void applyForInternship(InternshipOffer internshipOffer, Long idStudent);
}