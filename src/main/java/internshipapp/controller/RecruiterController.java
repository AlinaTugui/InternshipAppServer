package internshipapp.controller;

import internshipapp.persistence.model.Recruiter;
import internshipapp.service.RecruiterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("recruiter")
@CrossOrigin(origins = "*")
public class RecruiterController {
    @Resource
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Recruiter recruiter) {
        return new ResponseEntity<>(recruiterService.save(recruiter), HttpStatus.OK);
    }

}
