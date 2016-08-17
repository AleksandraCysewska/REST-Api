package token.cysewskaa.crudInterfaces;

import token.cysewskaa.entities.AddressEntity;

import java.util.List;

/**
 * Created by izodorczyka on 2016-08-01.
 */
public interface IAdressEntity {
    List<AddressEntity> getAddressList(long personId);
    AddressEntity getAddressById(long personId, Long adressId);
    void setAddress(AddressEntity data, long personId);
    void updateAddress(AddressEntity data, Long personId, Long addressId);
}
