package net.qualicoder.pub.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "beverage_types")
public class BeverageType extends AbstractPersistable<Long> {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private boolean alcoholic;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(nullable = false)
  private String pictureUrl;
}

