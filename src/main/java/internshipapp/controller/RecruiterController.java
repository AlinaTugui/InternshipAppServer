package internshipapp.controller;

import internshipapp.persistence.model.Recruiter;
import internshipapp.persistence.model.dtos.RecruiterDto;
import internshipapp.persistence.model.exception.RecruiterException;
import internshipapp.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/recruiters")
public class RecruiterController {
    private final RecruiterService recruiterService;
    private final ModelMapper modelMapper;

    @GetMapping("/email")
    public ResponseEntity<Recruiter> getUserByEmail(@RequestParam("email") String email) throws RecruiterException {
        Recruiter recruiter = recruiterService.getRecruiterByEmail(email);

        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recruiter> saveUser(@RequestBody RecruiterDto recruiter) throws RecruiterException {
        Recruiter r = modelMapper.map(recruiter, Recruiter.class);
        Recruiter savedRecruiter = recruiterService.saveRecruiter(r);

        return new ResponseEntity<>(savedRecruiter, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        List<Recruiter> recruiterList = recruiterService.getAllRecruiters();

        return new ResponseEntity<>(recruiterList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) throws RecruiterException {
        Recruiter recruiter = recruiterService.getRecruiterById(id);

        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }

}
