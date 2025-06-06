package JPAcourse.service.impl;

import JPAcourse.dto.NewVisitTO;
import JPAcourse.dto.PatientTO;
import JPAcourse.dto.VisitTO;
import JPAcourse.mapper.PatientMapper;
import JPAcourse.mapper.VisitMapper;
import JPAcourse.persistence.dao.PatientDao;
import JPAcourse.persistence.entity.PatientEntity;
import JPAcourse.persistence.entity.VisitEntity;
import JPAcourse.rest.exception.EntityNotFoundException;
import JPAcourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);

        return PatientMapper.mapToTO(entity);
    }

    @Override
    public PatientTO createNewVisit(NewVisitTO newVisitTO) {
        final PatientEntity entity = patientDao.addVisitToPatient(
                newVisitTO.getPatientId(),
                newVisitTO.getDoctorId(),
                newVisitTO.getTime(),
                newVisitTO.getDescription()
        );

        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void delete(Long id) {
        patientDao.delete(id);
    }

    @Override
    public List<VisitTO> findVisitsByPatientId(Long patientId) {
        List<VisitEntity> visits = patientDao.getOne(patientId).getVisits();
        return visits.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
