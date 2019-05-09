package net.qualicoder.pub.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

public class SimpleHeaderAuthentication extends AbstractAuthenticationToken {

  public SimpleHeaderAuthentication(long userId) {
    super(new ArrayList<GrantedAuthority>());
    this.userId = userId;
  }

  private final long userId;

  @Override
  public Long getCredentials() {
    return userId;
  }

  @Override
  public Long getPrincipal() {
    return userId;
  }
}
