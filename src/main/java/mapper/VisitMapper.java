package mapper;

public class VisitMapper {
    public static VisitTO toTO(Visit entity) {
        VisitTO to = new VisitTO();
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
