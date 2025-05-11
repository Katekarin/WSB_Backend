package JPAcourse.persistence.dao.impl;

import JPAcourse.persistence.dao.AddressDao;
import JPAcourse.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao
{

}
