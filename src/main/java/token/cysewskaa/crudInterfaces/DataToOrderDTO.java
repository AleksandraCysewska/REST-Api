package token.cysewskaa.crudInterfaces;


import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.entities.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;


/**
 * Created by cysewskaa on 2016-08-11.
 */

@Component
public class DataToOrderDTO {

    @PersistenceContext
    private EntityManager entityManager;

    final static Logger logger = Logger.getLogger(DataToOrderDTO.class);
    @Autowired
    OrderDTO orderDTO ;

    @Transactional
    public OrderDTO setFirstName(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> c = cb.createQuery(PersonEntity.class);
        Root<PersonEntity> p = c.from(PersonEntity.class);
        Predicate condition = cb.equal(p.get("id"), id);
        c.where(condition);
        TypedQuery<PersonEntity> q = entityManager.createQuery(c);
        List<PersonEntity> list = q.getResultList();

        for (PersonEntity personEntity : list) {
            orderDTO.setFname(personEntity.getFname());
            orderDTO.setLname(personEntity.getLname());

        }


        CriteriaBuilder cb2 = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonEntity> c2 = cb2.createQuery(PersonEntity.class);
        Root<PersonEntity> p2 = c2.from(PersonEntity.class);
        TypedQuery<PersonEntity> q2 = entityManager.createQuery(c2);
        Predicate condition2 = cb.equal(p2.get("id"), id);
        c.where(condition2);


       // Join<PersonEntity, AddressEntity> personEntityAddressEntityJoin = p2.join("addressEntities");
      //  Join<AddressEntity, OrderEntity> addressEntityOrderEntityJoin = personEntityAddressEntityJoin.join("orderEntity");
      //  Join<OrderEntity, CopyOfFlowerEntity> entityCopyOfFlowerEntityJoin = addressEntityOrderEntityJoin.join("copyOfFlowerEntities");

                c2.select(p2.get("addressEntities")).where((cb2.equal(p2.get("id"), id)));


       // TypedQuery<PersonEntity> query = entityManager.createQuery(c2);
       // logger.info("PPPP " + query.getSingleResult());
        TypedQuery<PersonEntity> q22 = entityManager.createQuery(c2);
        List<PersonEntity> list2 = q22.getResultList();


orderDTO.setFlowerName(list2);





     /*           logger.info("AAAAAA " + String.valueOf(orderEntity.getAddressEntities().toString()));*/
      //    flowersEntities.add(0, orderEntity.getAddressEntities().get(0));


       // orderDTO.setFlowerName((List<FlowersEntity>) resultList);


/*

        CriteriaBuilder cb2 = entityManager.getCriteriaBuilder();
        CriteriaQuery<CopyOfFlowerEntity> c2 = cb2.createQuery(CopyOfFlowerEntity.class);
        Root<CopyOfFlowerEntity> p2= c2.from(CopyOfFlowerEntity.class);
        Predicate condition2 = cb2.equal(p2.get("id"), id);
        c2.where(condition2);

*/
        return orderDTO;

    }
}
