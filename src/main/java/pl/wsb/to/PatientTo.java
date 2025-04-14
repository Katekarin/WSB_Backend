package pl.wsb.to;

public class PatientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate; // ← przykładowe pole innego typu niż String

    private List<VisitTO> visits; // ← lista odbytych wizyt
}

