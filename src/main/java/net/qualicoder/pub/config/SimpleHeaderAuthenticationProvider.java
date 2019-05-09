package net.qualicoder.pub.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class SimpleHeaderAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    System.out.println("provider " + authentication.getCredentials());

    authentication.setAuthenticated(true);
    return authentication;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return SimpleHeaderAuthentication.class.isAssignableFrom(authentication);
  }
}
