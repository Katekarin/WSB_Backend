package pl.wsb.to;

import java.time.LocalDate;
import java.util.List;
import pl.wsb.to.VisitTo;


public class PatientTo {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private List<VisitTo> visits;
}

