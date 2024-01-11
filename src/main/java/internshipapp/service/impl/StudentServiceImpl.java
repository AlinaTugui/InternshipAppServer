package internshipapp.service.impl;

import internshipapp.persistence.model.Student;
import internshipapp.persistence.repository.StudentRepository;
import internshipapp.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student findByEmailAndPassword(String email, String password) {
        return studentRepository.findStudentByEmailAndPassword(email, password);
    }

}
