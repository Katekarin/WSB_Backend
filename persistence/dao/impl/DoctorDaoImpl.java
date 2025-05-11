package JPAcourse.persistence.dao.impl;

import JPAcourse.persistence.dao.DoctorDao;
import JPAcourse.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {

}
