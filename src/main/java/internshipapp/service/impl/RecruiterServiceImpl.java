package internshipapp.service.impl;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.repository.RecruiterRepository;
import internshipapp.service.RecruiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Resource
    private RecruiterRepository recruiterRepository;

    @Override
    public Recruiter save(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @Override
    public List<Recruiter> findAll() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter findById(Long recruiterId) {
        return recruiterRepository.findById(recruiterId).get();
    }

    @Override
    public Recruiter findByEmailAndPassword(String email, String password) {
        return recruiterRepository.findRecruiterByEmailAndPassword(email, password);
    }
}