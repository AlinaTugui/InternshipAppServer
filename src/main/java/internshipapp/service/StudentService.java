package internshipapp.service;

import internshipapp.persistence.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student) throws Exception;

    List<Student> getAllStudents();

    Student getStudentById(Long id) throws Exception;

    Student getStudentByEmail(String email) throws Exception;
}