package token.cysewskaa.implementation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.crudInterfaces.DataToOrderDTO;
import token.cysewskaa.entities.PersonEntity;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by izodorczyka on 2016-08-01.
 */
@Slf4j
//@Scope( proxyMode = ScopedProxyMode.TARGET_CLASS)
  //      @Service
@Component
public class PersonEntityImpl  {

    @PersistenceContext
    private EntityManager entityManager;

@Autowired
DataToOrderDTO dataToOrderDTO;

    @Transactional
    public List<PersonEntity> getPersonList() {
     //  List list = entityManager.createQuery("select u from  UserDao u").getResultList();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> c = cb.createQuery(PersonEntity.class);
        Root<PersonEntity> p = c.from(PersonEntity.class);
        TypedQuery<PersonEntity> q = entityManager.createQuery(c);
        List<PersonEntity> list = q.getResultList();

        return  list;
    }

    @Transactional
    public PersonEntity getPersonById(long personId) {

     CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> c = cb.createQuery(PersonEntity.class);
        Root<PersonEntity> p = c.from(PersonEntity.class);
        Predicate condition = cb.equal(p.get("id"), personId);
        c.where(condition);
        TypedQuery<PersonEntity> q = entityManager.createQuery(c);
        PersonEntity query = q.getSingleResult();
        return query ;
    }

    @Transactional
    public void setPerson(PersonEntity data){
        entityManager.persist(data);
    }

    @Transactional
    public void updatePerson(PersonEntity data, Long id){
        data.setId(id);
        entityManager.merge(data);
    }

    @Transactional
    public void deletePerson(long personId){
        entityManager.remove(entityManager.getReference(PersonEntity.class, personId));
    }


}
