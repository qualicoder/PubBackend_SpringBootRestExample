package net.qualicoder.pub.rest.dto;

import net.qualicoder.pub.model.Beverage;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class AddBeverageResponse {
  private final Beverage beverage;
}
