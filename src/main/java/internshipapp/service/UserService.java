package internshipapp.service;

import internshipapp.persistence.model.User;

public interface UserService {
    User login(String email, String password);
}
