package internshipapp.persistence.repository;

import internshipapp.persistence.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Recruiter findRecruiterByEmailAndPassword(String email, String password);
}
