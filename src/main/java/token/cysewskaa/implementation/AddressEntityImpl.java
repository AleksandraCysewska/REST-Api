package token.cysewskaa.implementation;



import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.crudInterfaces.IAdressEntity;

import token.cysewskaa.entities.AddressEntity;
import token.cysewskaa.entities.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by izodorczyka on 2016-08-01.
 */
@Component
public class AddressEntityImpl implements IAdressEntity {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public List<AddressEntity> getAddressList(long personId) {
        TypedQuery<PersonEntity> query = entityManager.createQuery("SELECT d from PersonEntity d where d.id = :personId", PersonEntity.class);
        query.setParameter("personId",personId);
        List<AddressEntity> list = query.getSingleResult().getAddressEntities();
        return list;
    }

    @Transactional
    public AddressEntity getAddressById(long personId, Long adressId) {
        TypedQuery<AddressEntity> query = entityManager.createQuery("SELECT a from AddressEntity a, PersonEntity p where a.personDAO = p and p.id= :personId and a.id = :adressId", AddressEntity.class);
        query.setParameter("adressId",adressId);
        query.setParameter("personId",personId);
        AddressEntity singleResult = query.getSingleResult();
        return singleResult;
    }

    @Transactional
    public void setAddress(AddressEntity data, long personId){
        PersonEntity reference = entityManager.getReference(PersonEntity.class, personId);
        data.setPersonEntity(reference);
        entityManager.persist(data);
    }


    @Transactional
    public void updateAddress(AddressEntity data, Long personId, Long addressId){
        data.setId(addressId);
        entityManager.merge(data);
    }

    @Transactional
    public void deleteAddress(long personId, Long addressId){
        PersonEntity person = entityManager.getReference(PersonEntity.class, personId);
        TypedQuery<AddressEntity> query = entityManager.createQuery("SELECT a from AddressEntity a, PersonEntity p where a.personDAO = p and p.id= :personId and a.id = :adressId", AddressEntity.class);
        query.setParameter("adressId",addressId);
        query.setParameter("personId",personId);
        AddressEntity adress = query.getSingleResult();
        person.getAddressEntities().remove(adress);
        entityManager.remove(adress);
    }


}
