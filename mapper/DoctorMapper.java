package JPAcourse.mapper;

import JPAcourse.dto.DoctorTO;
import JPAcourse.persistence.entity.DoctorEntity;

public final class DoctorMapper {

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        final DoctorTO doctorTO = new DoctorTO();

        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());

        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());

        return doctorEntity;
    }
}
