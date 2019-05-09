package net.qualicoder.pub.service;

import net.qualicoder.pub.model.User;
import net.qualicoder.pub.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Transactional
  public long loginOrRegister(String username) {
    User user = userRepository.getByUsername(username)
        .orElseGet(() ->
            userRepository.save(
                User.builder()
                .username(username)
                .money(BigDecimal.valueOf(100L) )
                .build()
            )
        );

    return user.getId();
  }
}
