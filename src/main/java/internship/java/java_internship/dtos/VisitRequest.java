package internship.java.java_internship.dtos;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public record VisitRequest(@NotEmpty Date date,
                           @NotEmpty @Size(min = 2, max = 30) String name,
                           @NotEmpty @Size(min = 2, max = 30) String surname,
                           @NotEmpty String catName,
                           @NotEmpty int catAge,
                           @NotEmpty String catColor) {
}
