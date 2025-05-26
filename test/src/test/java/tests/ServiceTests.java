package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceTests
{
    private final PatientService _patientService;

    public ServiceTests(PatientService patientService){
        this._patientService = patientService;
    }

    @Test
    public void PatientService_findVisitsByPatientId_Should_Return_Collection_Of_Visits(){
        var visits = _patientService.findVisitsByPatientId(5);

        Assertions.assertTrue(visits.size() > 3);
    }
}
