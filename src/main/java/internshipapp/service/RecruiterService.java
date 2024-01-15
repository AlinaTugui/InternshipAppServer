package internshipapp.service;

import internshipapp.persistence.model.Recruiter;

import java.util.List;

public interface RecruiterService {
    Recruiter saveRecruiter(Recruiter recruiter) throws Exception;

    List<Recruiter> getAllRecruiters();

    Recruiter getRecruiterByEmail(String email) throws Exception;

    Recruiter getRecruiterById(Long id) throws Exception;

}