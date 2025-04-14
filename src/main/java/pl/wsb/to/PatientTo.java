package pl.wsb.to;

public class PatientTo {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private List<VisitTO> visits;
}

