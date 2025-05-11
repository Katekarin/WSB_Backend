package JPAcourse.mapper;

import JPAcourse.dto.MedicalTreatmentTO;
import JPAcourse.persistence.entity.MedicalTreatmentEntity;

public final class MedicalTreatmentMapper {
    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity) {
        final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setType(medicalTreatmentEntity.getType());

        return medicalTreatmentTO;
    }

    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTO) {
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setType(medicalTreatmentTO.getType());

        return medicalTreatmentEntity;
    }
}
