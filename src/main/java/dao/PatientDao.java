package dao;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, Long> {
    @Modifying
    @Transactional
    @Query("insert into VisitEntity (patient, doctor, date, description) " +
            "select p, d, :date, :description from PatientEntity p, DoctorEntity d where p.id = :patientId and d.id = :doctorId")
    void addVisit(@Param("patientId") Long patientId,
                  @Param("doctorId") Long doctorId,
                  @Param("date") LocalDateTime date,
                  @Param("description") String description);

}

