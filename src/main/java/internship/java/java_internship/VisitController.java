package internship.java.java_internship;

import internship.java.java_internship.dtos.VisitRequest;
import internship.java.java_internship.dtos.VisitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(path = "api/visit")
@RequiredArgsConstructor
public class VisitController {

        private final VisitService visitService;

        @GetMapping(path = "{id}")
        public ResponseEntity<VisitResponse> getVisit(@PathVariable("id") long id) {
            return ResponseEntity.ok(visitService.getVisit(id));
        }

        @GetMapping
        public ResponseEntity<List<VisitResponse>> getBooks() {
            return ResponseEntity.ok(visitService.getVisits());
        }

        @PostMapping
        public ResponseEntity<VisitResponse> createVisit(@RequestBody @Valid VisitRequest visitRequest) {
            return ResponseEntity.status(HttpStatus.CREATED).body(visitService.createVisit(visitRequest));
        }


        @DeleteMapping(path = "{id}")
        public ResponseEntity<VisitResponse> deleteVisit(@PathVariable("id") long id) {
            return visitService.deleteVisit(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping(path = "{id}")
        public ResponseEntity<VisitResponse> updateBook(@PathVariable("id") long id, @RequestBody @Valid VisitRequest visitRequest) {
            return ResponseEntity.ok(visitService.updateVisit(id, visitRequest));
        }


        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(NoSuchElementException.class)
        public Map<String, String> handleNoSuchElementException(NoSuchElementException e) {
            return Map.of("message", e.getMessage());
        }
}
