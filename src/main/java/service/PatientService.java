package service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientDao patientDao;

    public PatientTO getPatientById(Long id) {
        return patientDao.findById(id)
                .map(PatientMapper::toTO)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void deletePatient(Long id) {
        patientDao.deleteById(id);
    }
}

