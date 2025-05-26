package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.experimental.theories.Theories;
import JPAcourse.persistence.dao;

public class DaoTests {
    @Test
    public void PatientDao_FindBySurname_Should_Return_List_of_Patients(){
        PatientDao patientsRepository = new PatientDao();
        List<PatientEntity> patients = patientsRepository.findBySurname("Nowak");

        Assertions.assertEquals(patients.size(), 1);
    }

    @Test
    public void VisitDao_GetPatientsWithVisits_Should_Return_List_of_Patients(){
        PatientDao patientRepository = new PatientDao();
        List<PatientEntity> patients = patientRepository.findPatientsWithVisits(3);

        Assertions.assertEquals(patients.size(), 3);
    }

    @Test
    public void PatientDao_findPatientsOlderThen_Should_Return_List_of_Patients(){
        PatientDao patientRepository = new PatientDao();
        List<PatientEntity> patients = patientRepository.findPatientsOlderThen(1990, 1, 1);

        Assertions.assertTrue(patients.size() >= 5);
    }

}
