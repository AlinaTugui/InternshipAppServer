package internshipapp.persistence.repository;

import internshipapp.persistence.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByEmailAndPassword(String email, String password);
}
