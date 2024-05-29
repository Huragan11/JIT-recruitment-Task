package internship.java.java_internship;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class VisitInitializer implements CommandLineRunner {
    private final VisitRepository visitRepository;

    @Override
    public void run(String... args) {
        Visit visit1 = new Visit();
        visit1.setDate(new Date(2024-1900, Calendar.MAY,29,12,0));
        visit1.setName("Alex");
        visit1.setSurname("Johnson");
        visit1.setCatName("Catty");
        visit1.setCatAge(7);
        visit1.setCatColor("black");

        Visit visit2 = new Visit();
        visit2.setDate(new Date(2024-1900, Calendar.MAY,31,15,0));
        visit2.setName("Mason");
        visit2.setSurname("Testy");
        visit2.setCatName("Catter");
        visit2.setCatAge(10);
        visit2.setCatColor("white");

        visitRepository.save(visit1);
        visitRepository.save(visit2);
    }
}
