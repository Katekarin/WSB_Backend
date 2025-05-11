package JPAcourse.mapper;

import JPAcourse.dto.VisitTO;
import JPAcourse.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class VisitMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        final VisitTO visitTO = new VisitTO();
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        visitTO.setDoctor(
                DoctorMapper.mapToTO(visitEntity.getDoctor())
        );

        visitTO.setTreatments(
                visitEntity.getTreatments().stream()
                        .map(MedicalTreatmentMapper::mapToTO)
                        .collect(Collectors.toList())
        );

        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        VisitEntity visitEntity = new VisitEntity();

        return visitEntity;
    }
}
