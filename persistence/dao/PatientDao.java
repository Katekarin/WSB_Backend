package JPAcourse.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import JPAcourse.Patient;

import org.springframework.data.repository.query.Param;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Visit (patient, doctor, date, description) " +
            "SELECT p, d, :date, :description FROM Patient p, Doctor d " +
            "WHERE p.id = :patientId AND d.id = :doctorId")
    void addVisit(@Param("patientId") Long patientId,
                  @Param("doctorId") Long doctorId,
                  @Param("date") LocalDateTime date,
                  @Param("description") String description);
}

