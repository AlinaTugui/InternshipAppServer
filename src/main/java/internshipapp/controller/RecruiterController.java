package internshipapp.controller;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.exception.RecruiterException;
import internshipapp.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/recruiters")
public class RecruiterController {
    private final RecruiterService recruiterService;

    @GetMapping("/email")
    public ResponseEntity<Recruiter> getUserByEmail(@RequestParam("email") String email) throws RecruiterException {
        Recruiter recruiter = recruiterService.getRecruiterByEmail(email);

        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recruiter> saveUser(@RequestBody Recruiter recruiter) throws RecruiterException {
        Recruiter savedRecruiter = recruiterService.saveRecruiter(recruiter);

        return new ResponseEntity<>(savedRecruiter, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        List<Recruiter> recruiterList = recruiterService.getAllRecruiters();

        return new ResponseEntity<>(recruiterList, HttpStatus.OK);
    }

}
