package token.cysewskaa.crudInterfaces;

import token.cysewskaa.entities.UserDao;

/**
 * Created by izodorczyka on 2016-08-09.
 */
public interface IUserEntity {
    UserDao findByUsername(String username);
}
