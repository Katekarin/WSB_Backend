package JPAcourse.service;

import JPAcourse.dto.NewVisitTO;
import JPAcourse.dto.PatientTO;
import JPAcourse.dto.VisitTO;

import java.util.List;

public interface PatientService
{
    public PatientTO findById(final Long id);
    public PatientTO createNewVisit(final NewVisitTO newVisitTO);
    public void delete(final Long id);
    public List<VisitTO> findVisitsByPatientId(final Long patientId);
}
