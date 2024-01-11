package internshipapp.controller;

import internshipapp.persistence.model.Student;
import internshipapp.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

}
