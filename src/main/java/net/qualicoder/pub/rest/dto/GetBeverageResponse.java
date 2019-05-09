package net.qualicoder.pub.rest.dto;

import net.qualicoder.pub.model.Beverage;
import net.qualicoder.pub.model.BeverageType;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetBeverageResponse {
  List<BeverageType> beverageTypes;
  List<Beverage> myBeverages;
}
