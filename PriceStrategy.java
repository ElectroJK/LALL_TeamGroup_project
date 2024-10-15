interface PriceStrategy {
  double CalculatePrice(double BasePrice);
}

class RegularPriceStrategy implements PriceStrategy {
  @Override
  public double CalculatePrice(double BasePrice) {
    return BasePrice;
  }
}

class DiscountPriceStrategy implements PriceStrategy {
  private double discount;

  public DiscountPriceStrategy(double discount) {
    this.discount = discount;
  }

  @Override
  public double CalculatePrice(double BasePrice) {
    return BasePrice - discount;
  }
}
