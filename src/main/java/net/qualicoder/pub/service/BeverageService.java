package net.qualicoder.pub.service;

import net.qualicoder.pub.model.Beverage;
import net.qualicoder.pub.model.BeverageType;
import net.qualicoder.pub.model.User;
import net.qualicoder.pub.model.misc.BeverageState;
import net.qualicoder.pub.model.repo.BeverageRepository;
import net.qualicoder.pub.model.repo.BeverageTypeRepository;
import net.qualicoder.pub.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeverageService {

  private UserRepository userRepository;
  private BeverageTypeRepository beverageTypeRepository;
  private BeverageRepository beverageRepository;

  @Transactional(readOnly = true)
  public List<BeverageType> getBeverageTypes() {
    return beverageTypeRepository.findAll();
  }

  @Transactional(readOnly = true)
  public List<Beverage> getUsersBeverages(Long userId) {

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalStateException("User must exists!"));

    return user.getBeverages();
  }

  @Transactional
  public Beverage addBeverage(Long beverageTypeId, Long userId) {

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalStateException("User must exists!"));

    BeverageType beverageType = beverageTypeRepository.findById(beverageTypeId)
        .orElseThrow(() -> new IllegalStateException("BeverageType must exists!"));

    return beverageRepository.save(Beverage.builder()
        .beverageType(beverageType)
        .state(BeverageState.full)
        .user(user)
        .build());
  }
}
