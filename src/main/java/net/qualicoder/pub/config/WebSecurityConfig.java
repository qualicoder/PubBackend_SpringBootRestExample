package net.qualicoder.pub.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private SimpleHeaderAuthenticationProvider simpleHeaderAuthenticationProvider;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(simpleHeaderAuthenticationProvider);
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(POST, "/login").permitAll()
        .antMatchers(GET, "/beverages").fullyAuthenticated()
        .antMatchers(POST, "/beverages").fullyAuthenticated()
        .and()
        .addFilterBefore(new SimpleHeaderAuthFilter(authenticationManager()),
            BasicAuthenticationFilter.class)
        .csrf().disable();
  }
}
