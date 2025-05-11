package JPAcourse.persistence.dao.impl;

import JPAcourse.persistence.dao.VisitDao;
import JPAcourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao
{

}
