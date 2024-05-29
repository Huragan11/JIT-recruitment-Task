package internship.java.java_internship;

import internship.java.java_internship.dtos.VisitRequest;
import internship.java.java_internship.dtos.VisitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    @Transactional(readOnly = true)
    public VisitResponse getVisit(long id) {
        return visitRepository.findById(id).get().toResponse();
    }
    @Transactional(readOnly = true)
    public List<VisitResponse> getVisits() {
        return visitRepository.findAll().stream().map(Visit::toResponse).toList();
    }
    @Transactional
    public VisitResponse createVisit(VisitRequest visitRequest) {
        Optional<Visit> existingVisit = visitRepository.findByDate(visitRequest.date());
        if (existingVisit.isEmpty() && visitRequest.date().getHours() >= 8 && visitRequest.date().getHours() < 15 && visitRequest.date().getMinutes() == 0){
            Visit visit = new Visit();
            visit.setDate(visitRequest.date());
            visit.setName(visitRequest.name());
            visit.setSurname(visitRequest.surname());
            visit.setCatName(visitRequest.catName());
            visit.setCatAge(visitRequest.catAge());
            visit.setCatColor(visitRequest.catColor());
            visitRepository.save(visit);
            return visitRepository.save(visit).toResponse();
        }
        return null;
    }

    @Transactional
    public Optional<VisitResponse> deleteVisit(long id) {
        Optional<VisitResponse> visitResponse = visitRepository.findById(id).map(Visit::toResponse);
        visitRepository.deleteById(id);
        return visitResponse;
    }

    @Transactional
    public VisitResponse updateVisit(long id, VisitRequest visitRequest) {

        Visit visit = visitRepository.findById(id).orElseThrow();
        if (visitRequest.date().getHours() >= 8 && visitRequest.date().getHours() < 15 && visitRequest.date().getMinutes() == 0){
            visit.setDate(visitRequest.date());
        }
        visit.setName(visitRequest.name());
        visit.setSurname(visitRequest.surname());
        visit.setCatName(visitRequest.catName());
        visit.setCatAge(visitRequest.catAge());
        visit.setCatColor(visitRequest.catColor());
        return visitRepository.save(visit).toResponse();
    }
}
