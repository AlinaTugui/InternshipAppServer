package internshipapp.controller;

import internshipapp.persistence.model.User;
import internshipapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/{email}/{password}")
    public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password) {
        User user = userService.login(email, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
