package net.qualicoder.pub.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends AbstractPersistable<Long> {

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private BigDecimal money;

  @OneToMany(mappedBy = "user")
  private List<Beverage> beverages;

}
