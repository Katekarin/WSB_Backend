package tests;
@Test
@Transactional
public class gettingPatient
    PatientTO patient = patientService.getPatientById(1L);
    assertEquals("Anna", patient.getFirstName());
    assertEquals(LocalDate.of(1990, 1, 1), patient.getBirthDate());
    assertEquals(1, patient.getVisits().size());{
}
