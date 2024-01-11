package internshipapp.service;

import internshipapp.persistence.model.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    List<Student> findAll();

    Student findById(Long studentId);

    Student findByEmailAndPassword(String email, String password);

}
