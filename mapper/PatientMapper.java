package JPAcourse.mapper;

import JPAcourse.dto.PatientTO;
import JPAcourse.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        final PatientTO patientTO = new PatientTO();

        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());

        patientTO.setVisits(
                patientEntity.getVisits().stream()
                        .map(VisitMapper::mapToTO)
                        .collect(Collectors.toList())
        );

        patientTO.setGender(patientEntity.getGender());

        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setGender(patientTO.getGender());

        return patientEntity;
    }
}
