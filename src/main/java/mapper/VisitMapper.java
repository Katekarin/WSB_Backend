package mapper;

public class PatientMapper {
    public static PatientTO toTO(PatientEntity entity) {
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setBirthDate(entity.getBirthDate());

        List<VisitTO> visits = entity.getVisits().stream()
                .map(VisitMapper::toTO)
                .collect(Collectors.toList());
        to.setVisits(visits);

        return to;
    }
}
