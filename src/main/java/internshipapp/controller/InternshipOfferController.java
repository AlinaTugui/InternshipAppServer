package internshipapp.controller;

import internshipapp.persistence.dtos.InternshipDto;
import internshipapp.persistence.dtos.InternshipRequest;
import internshipapp.persistence.dtos.InternshipResponse;
import internshipapp.persistence.model.InternshipOffer;
import internshipapp.service.InternshipOfferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/internships")
public class InternshipOfferController {
    private final InternshipOfferService internshipOfferService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InternshipResponse>> getAllInternships() {
        List<InternshipResponse> internshipsList = internshipOfferService.getAllInternshipOffers().stream().map(
                x -> {
                    InternshipResponse response = new InternshipResponse(x.getId(),x.getCity(),x.getType(),x.getDescription(),x.getDomain(),x.getPaid(),x.getRecruiter().getFirstName(),
                            x.getRecruiter().getLastName(),x.getRecruiter().getEmail(),x.getRecruiter().getPhoneNumber(),x.getRecruiter().getCompanyName());
                    return response;
                }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(internshipsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<InternshipOffer>> getAllInternshipsForRecruiter(@PathVariable Long id) {
        List<InternshipOffer> internshipsList = internshipOfferService.getAllInternshipOfferForRecruiter(id);

        return new ResponseEntity<>(internshipsList, HttpStatus.OK);
    }

    @PostMapping("/internship-application")
    public ResponseEntity<Object> applyForInternship(@RequestBody InternshipRequest internshipDto) {

        internshipOfferService.applyForInternship(internshipDto.getIdInternship(),internshipDto.getIdUser());

        return new ResponseEntity<>("Application submitted successfully!", HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Object> createInternshipOffer(@RequestBody InternshipDto internshipDto) {
        InternshipOffer internshipOffer = modelMapper.map(internshipDto, InternshipOffer.class);
        internshipOfferService.saveInternshipOffer(internshipOffer,internshipDto.getIdUser());

        return new ResponseEntity<>("Internship Offer saved successfully!", HttpStatus.OK);

    }
}