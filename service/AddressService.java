package JPAcourse.service;

import JPAcourse.dto.AddressTO;

public interface AddressService
{
    public AddressTO findById(final Long id);
}
