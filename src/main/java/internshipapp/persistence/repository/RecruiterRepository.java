package internshipapp.persistence.repository;

import internshipapp.persistence.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Optional<Recruiter> findRecruiterByEmail(String email);

    Recruiter findRecruiterByEmailAndPassword(String email, String password);
}
