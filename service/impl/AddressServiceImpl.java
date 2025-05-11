package JPAcourse.service.impl;

import JPAcourse.dto.AddressTO;
import JPAcourse.mapper.AddressMapper;
import JPAcourse.persistence.dao.AddressDao;
import JPAcourse.persistence.entity.AddressEntity;
import JPAcourse.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AddressServiceImpl implements AddressService
{
    private final AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao pAddressDao)
    {
        addressDao = pAddressDao;
    }

    @Override
    public AddressTO findById(Long id) {
        final AddressEntity entity = addressDao.findOne(id);
        return AddressMapper.mapToTO(entity);
    }
}
