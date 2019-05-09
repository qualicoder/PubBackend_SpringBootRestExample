package net.qualicoder.pub.rest;

import net.qualicoder.pub.rest.dto.LoginRequest;
import net.qualicoder.pub.rest.dto.LoginResponse;
import net.qualicoder.pub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginEndpoint {

  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    String username = loginRequest.getUsername();

    log.debug("logging in: {}", username);

    System.out.println(username);

    long id = userService.loginOrRegister(username);

    return LoginResponse.builder()
        .id(id)
        .userName(username)
        .build();
  }
}
