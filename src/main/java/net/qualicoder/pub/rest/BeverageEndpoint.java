package net.qualicoder.pub.rest;

import net.qualicoder.pub.model.Beverage;
import net.qualicoder.pub.model.BeverageType;
import net.qualicoder.pub.rest.dto.AddBeverageRequest;
import net.qualicoder.pub.rest.dto.AddBeverageResponse;
import net.qualicoder.pub.rest.dto.GetBeverageResponse;
import net.qualicoder.pub.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/beverages")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeverageEndpoint {

  private BeverageService beverageService;

  @GetMapping
  public GetBeverageResponse getBeverages() {

    Long userId = getUserIdFromAuthentication();

    List<BeverageType> beverageTypes = beverageService.getBeverageTypes();
    List<Beverage> usersBeverages = beverageService.getUsersBeverages(userId);

    return GetBeverageResponse.builder()
        .beverageTypes(beverageTypes)
        .myBeverages(usersBeverages)
        .build();
  }

  @PostMapping
  public AddBeverageResponse addBeverage(@RequestBody AddBeverageRequest addBeverageRequest,
                                         HttpServletRequest httpServletRequest) {

    String userIdString = httpServletRequest.getHeader("UserId");

    log.info("userIdString: " + userIdString);

    Long userId = getUserIdFromAuthentication();

    Beverage beverage = beverageService.addBeverage(addBeverageRequest.getBeverageTypeId(), userId);

    return new AddBeverageResponse(beverage);
  }

  private Long getUserIdFromAuthentication() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    log.info("credentials: {}", authentication.getCredentials());

    return (Long) authentication.getCredentials();
  }
}
