package internship.java.java_internship;

import internship.java.java_internship.dtos.VisitResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    String name;
    String surname;
    String catName;
    int catAge;
    String catColor;

    public VisitResponse toResponse(){
        return new VisitResponse(date,name,surname,catName,catAge,catColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(date, visit.date) && Objects.equals(name, visit.name) && Objects.equals(surname, visit.surname) && Objects.equals(catName, visit.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, surname, catName);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", catName='" + catName + '\'' +
                ", catAge=" + catAge +
                ", catColor='" + catColor + '\'' +
                '}';
    }
}



