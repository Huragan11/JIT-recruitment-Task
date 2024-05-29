package internship.java.java_internship.dtos;

import lombok.Builder;

import java.util.Date;

@Builder
public record VisitResponse(Date date,
                            String name,
                            String surname,
                            String catName,
                            int catAge,
                            String catColor) {
}
