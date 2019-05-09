package net.qualicoder.pub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.qualicoder.pub.model.misc.BeverageState;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "beverages")
public class Beverage extends AbstractPersistable<Long> {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "beverage_type_id", nullable = false)
  private BeverageType beverageType;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private BeverageState state;
}

