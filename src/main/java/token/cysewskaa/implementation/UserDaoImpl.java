package token.cysewskaa.implementation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.crudInterfaces.IUserEntity;
import token.cysewskaa.entities.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/*
 * Created by izodorczyka on 2016-08-09.
 */

@Component
public class UserDaoImpl implements IUserEntity {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public UserDao findByUsername(String username) {
        TypedQuery<UserDao> query = entityManager.createQuery("select u from " + UserDao.class.getName() + " u where u.username = :username", UserDao.class);
        query.setParameter("username",username);
        List<UserDao> resultList = query.getResultList();
        if(resultList.size() !=0)
        return resultList.get(0);
        else {
            return null;
        }
    }
}
