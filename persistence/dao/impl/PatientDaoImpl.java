package JPAcourse.persistence.dao.impl;

import JPAcourse.persistence.dao.PatientDao;
import JPAcourse.persistence.entity.DoctorEntity;
import JPAcourse.persistence.entity.PatientEntity;
import JPAcourse.persistence.entity.VisitEntity;
import JPAcourse.persistence.enums.Gender;
import JPAcourse.rest.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    @Transactional
    public PatientEntity addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);

        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        VisitEntity visit = new VisitEntity();
        visit.setTime(time);
        visit.setPatient(patient);
        visit.setDescription(description);
        visit.setDoctor(doctor);
        visit.setTreatments(new ArrayList<>());

        patient.getVisits().add(visit);

        entityManager.merge(patient);

        return patient;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        String query = "SELECT p FROM PatientEntity p WHERE p.lastName =: lastName";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreVisitsThan(long minVisit) {
        String query = "SELECT p FROM PatientEntity p JOIN VisitEntity v ON p.id = v.patient.id GROUP BY p.id HAVING COUNT(v.id) > :minVisit";
        return entityManager.createQuery(query, PatientEntity.class)
                .setParameter("minVisit", minVisit)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByGender(List<Gender> genderList) {
        return entityManager.createQuery(
                "SELECT patient FROM PatientEntity patient WHERE gender IN (:genderList)",
                        PatientEntity.class
                )
                .setParameter("genderList", genderList)
                .getResultList();
    }
}
