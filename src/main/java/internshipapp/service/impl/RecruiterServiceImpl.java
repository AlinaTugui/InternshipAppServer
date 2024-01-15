package internshipapp.service.impl;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.repository.RecruiterRepository;
import internshipapp.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecruiterServiceImpl implements RecruiterService {
    private final RecruiterRepository recruiterRepository;

    @Override
    public Recruiter saveRecruiter(Recruiter recruiter) throws Exception {
        if (recruiterRepository.findRecruiterByEmail(recruiter.getEmail()).isPresent()) {
            throw new Exception("This email already belong to a registered user");
        }

        return recruiterRepository.save(recruiter);
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter getRecruiterByEmail(String email) throws Exception {
        if (recruiterRepository.findRecruiterByEmail(email).isEmpty()) {
            throw new Exception("User with this email does not exist");
        }
        return recruiterRepository.findRecruiterByEmail(email).get();
    }

    @Override
    public Recruiter getRecruiterById(Long id) throws Exception {
        if (recruiterRepository.findById(id).isEmpty()) {
            throw new Exception("Recruiter with id="+id+" does not exist");
        }

        if (recruiterRepository.findById(id).isPresent()) {
            return recruiterRepository.findById(id).get();
        }

        return null;
    }
}