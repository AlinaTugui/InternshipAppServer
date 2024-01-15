package internshipapp.service;

import internshipapp.persistence.model.Recruiter;

import java.util.List;

public interface RecruiterService {
    Recruiter save(Recruiter recruiter);

    List<Recruiter> findAll();

    Recruiter findById(Long recruiterId);

    Recruiter findByEmailAndPassword(String email, String password);

}