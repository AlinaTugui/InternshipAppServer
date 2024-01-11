package internshipapp.controller;

import internshipapp.persistence.model.Student;
import internshipapp.persistence.model.dtos.StudentDto;
import internshipapp.persistence.model.exception.StudentException;
import internshipapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping("/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam("email") String email) throws StudentException {
        Student student = studentService.getStudentByEmail(email);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDto student) throws StudentException {
        Student s = modelMapper.map(student, Student.class);
        Student savedstudent = studentService.saveStudent(s);

        return new ResponseEntity<>(savedstudent, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws StudentException {
        Student student = studentService.getStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
