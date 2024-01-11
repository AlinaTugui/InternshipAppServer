package internshipapp.controller;

import internshipapp.persistence.model.Student;
import internshipapp.persistence.model.exception.StudentException;
import internshipapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam("email") String email) throws StudentException {
        Student student = studentService.getStudentByEmail(email);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws StudentException {
        Student savedstudent = studentService.saveStudent(student);

        return new ResponseEntity<>(savedstudent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable Long id) throws StudentException {
        Student student = studentService.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
