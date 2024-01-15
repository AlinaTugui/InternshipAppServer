package internshipapp.persistence.repository;

import org.springframework.stereotype.Repository;

import internshipapp.persistence.model.InternshipOffer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InternshipOfferRepository extends JpaRepository<InternshipOffer, Long> {

}