package net.qualicoder.pub.model.repo;

import net.qualicoder.pub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> getByUsername(String username);
}
