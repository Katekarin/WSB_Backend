package tests;

public class AddVisitToPatient {
    @Test
    @Transactional
    void shouldAddVisitToPatient() {
        patientDao.addVisit(1L, 1L, LocalDateTime.now(), "Nowa kontrola");

        PatientEntity patient = patientDao.findById(1L).orElseThrow();
        assertEquals(2, patient.getVisits().size());
    }

}
