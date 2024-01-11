package internshipapp.service.impl;

import internshipapp.persistence.model.Student;
import internshipapp.persistence.model.exception.StudentException;
import internshipapp.persistence.repository.StudentRepository;
import internshipapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) throws StudentException {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new StudentException("This email already belongs to a registered student");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) throws StudentException {
        if (studentRepository.findById(id).isEmpty()) {
            throw new StudentException("Student with id="+id+" does not exist");
        }

        if (studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public Student getStudentByEmail(String email) throws StudentException {
        if (studentRepository.findStudentByEmail(email).isEmpty()) {
            throw new StudentException("User with this email does not exist" + email);
        }
        return studentRepository.findStudentByEmail(email).get();
    }
}
