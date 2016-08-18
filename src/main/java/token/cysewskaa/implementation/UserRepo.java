package token.cysewskaa.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.entities.PersonEntity;
import token.cysewskaa.entities.UserDao;

import java.util.List;

/**
 * Created by cysewskaa on 2016-08-18.
 */
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<UserDao,Long> {

    @Query("select u from token.cysewskaa.entities.UserDao u where u.username=:username")
    List<UserDao> getPersonListByLogin(@Param("username") String username);

}
