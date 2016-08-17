package token.cysewskaa.service.impl;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import token.cysewskaa.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

  @Override
  public Boolean hasProtectedAccess() {
    return (SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN")));
  }

}
