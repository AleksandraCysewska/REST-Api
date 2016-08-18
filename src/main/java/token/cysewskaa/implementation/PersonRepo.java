package token.cysewskaa.implementation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import token.cysewskaa.entities.AddressEntity;
import token.cysewskaa.entities.PersonEntity;


import java.util.List;

/**
 * Created by cysewskaa on 2016-08-10.
 */

@Transactional(readOnly = true)
public interface PersonRepo extends JpaRepository<PersonEntity,Long> {

    @Query("from token.cysewskaa.entities.PersonEntity ")
     List<PersonEntity> getAllPerson();

    @Query("select u from token.cysewskaa.entities.PersonEntity u where u.id=:id")
    PersonEntity getPersonById(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query("delete from token.cysewskaa.entities.PersonEntity u where u.id=:id")
    void deletePersonById(@Param("id") Long id);

    @Modifying
    @Query("update from token.cysewskaa.entities.PersonEntity u set u=:personEntity where u.id=:id")
     void updatePerson(@Param("id") Long id, @Param("personEntity")PersonEntity personEntity);
/*
* TODO-FIX UPDATE*/

    @Transactional
    @Modifying
    @Query("update from token.cysewskaa.entities.AddressEntity u set u=:addressEntity where u.id=:id")
    void updateAddress(@Param("id") Long id, @Param("addressEntity")AddressEntity addressEntity);
//
}
