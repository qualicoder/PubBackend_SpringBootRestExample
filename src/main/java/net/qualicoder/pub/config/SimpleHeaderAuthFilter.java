package net.qualicoder.pub.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleHeaderAuthFilter extends OncePerRequestFilter {

  private final AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                  FilterChain filterChain) throws ServletException, IOException {

    String userId = httpServletRequest.getHeader("UserId");
    System.out.println(userId);

    if (userId != null) {
      Authentication
          authentication =
          authenticationManager.authenticate(new SimpleHeaderAuthentication(Long.parseLong(userId)));

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
