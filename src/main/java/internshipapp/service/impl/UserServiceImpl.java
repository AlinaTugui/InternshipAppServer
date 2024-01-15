package internshipapp.service.impl;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.Student;
import internshipapp.persistence.model.User;
import internshipapp.persistence.repository.RecruiterRepository;
import internshipapp.persistence.repository.StudentRepository;
import internshipapp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private RecruiterRepository recruiterRepository;

    @Override
    public User login(String email, String password) {
        Student student = studentRepository.findStudentByEmailAndPassword(email, password);
        if (student != null) {
            User user = new User(student.getId(), student.getFirstName(), student.getLastName(), false);
            return user;
        } else {
            Recruiter recruiter = recruiterRepository.findRecruiterByEmailAndPassword(email, password);
            if (recruiter != null) {
                return new User(recruiter.getId(), recruiter.getFirstName(), recruiter.getLastName(), true);
            } else {
                return null;
            }
        }
    }
}
