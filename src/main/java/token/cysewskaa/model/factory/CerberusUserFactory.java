package token.cysewskaa.model.factory;


import org.springframework.security.core.authority.AuthorityUtils;
import token.cysewskaa.entities.UserDao;
import token.cysewskaa.model.security.CerberusUser;

public class CerberusUserFactory {

  public static CerberusUser create(UserDao user) {
    return new CerberusUser(
      user.getId(),
      user.getUsername(),
      user.getPassword(),
      user.getEmail(),
      user.getLastPasswordReset(),
      AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
    );
  }

}
