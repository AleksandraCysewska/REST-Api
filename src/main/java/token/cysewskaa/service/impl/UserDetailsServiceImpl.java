package token.cysewskaa.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import token.cysewskaa.entities.UserDao;
import token.cysewskaa.implementation.UserDaoImpl;
import token.cysewskaa.model.factory.CerberusUserFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDaoImpl userDaoImpl;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDao user = userDaoImpl.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
      return CerberusUserFactory.create(user);
    }
  }

}
