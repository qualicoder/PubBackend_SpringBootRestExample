package net.qualicoder.pub.model.repo;

import net.qualicoder.pub.model.Beverage;
import net.qualicoder.pub.model.BeverageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}
