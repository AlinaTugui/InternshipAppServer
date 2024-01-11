package internshipapp.controller;

import internshipapp.persistence.model.InternshipOffer;
import internshipapp.persistence.model.dtos.InternshipDto;
import internshipapp.persistence.model.exception.StudentException;
import internshipapp.service.InternshipOfferService;
import internshipapp.service.RecruiterService;
import internshipapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/internships")
public class InternshipOfferController {
    private final InternshipOfferService internshipOfferService;
    private final RecruiterService recruiterService;
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InternshipOffer>> getAllInternships() {
        List<InternshipOffer> internshipsList = internshipOfferService.getAllInternshipOffers();

        return new ResponseEntity<>(internshipsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<InternshipOffer>> getAllInternshipsForRecruiter(@PathVariable Long id) {
        List<InternshipOffer> internshipsList = internshipOfferService.getAllInternshipOfferForRecruiter(id);

        return new ResponseEntity<>(internshipsList, HttpStatus.OK);
    }

    @PostMapping("/internship-application")
    public ResponseEntity<Object> applyForInternship(@RequestBody InternshipDto internshipDto) throws StudentException {
        InternshipOffer internshipOffer = modelMapper.map(internshipDto, InternshipOffer.class);
        internshipOfferService.applyForInternship(internshipOffer,internshipDto.getIdUser());

        return new ResponseEntity<>("Application submitted successfully!", HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Object> createInternshipOffer(@RequestBody InternshipDto internshipDto) {
        InternshipOffer internshipOffer = modelMapper.map(internshipDto, InternshipOffer.class);
        internshipOfferService.saveInternshipOffer(internshipOffer,internshipDto.getIdUser());

        return new ResponseEntity<>("Internship Offer saved successfully!", HttpStatus.OK);

    }
}
