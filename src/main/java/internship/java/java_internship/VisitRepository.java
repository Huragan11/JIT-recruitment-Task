package internship.java.java_internship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
interface VisitRepository extends JpaRepository<Visit, Long> {

    Optional<Visit> findByDate(Date date);
}
