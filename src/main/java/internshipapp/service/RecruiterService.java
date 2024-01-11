package internshipapp.service;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.exception.RecruiterException;

import java.util.List;

public interface RecruiterService {
    Recruiter saveRecruiter(Recruiter recruiter) throws RecruiterException;

    List<Recruiter> getAllRecruiters();

    Recruiter getRecruiterByEmail(String email) throws RecruiterException;

    Recruiter getRecruiterById(Long id) throws RecruiterException;

}
