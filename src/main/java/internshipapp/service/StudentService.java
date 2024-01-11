package internshipapp.service;

import internshipapp.persistence.model.Student;
import internshipapp.persistence.model.exception.StudentException;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student) throws StudentException;

    List<Student> getAllStudents();

    Student getStudentById(Long id) throws StudentException;

    Student getStudentByEmail(String email) throws StudentException;
 }
