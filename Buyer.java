interface Buyer {
  boolean canAfford(iPhone phone);
  void purchase(iPhone phone);
}

class iPhoneBuyer implements Buyer {
  private Person person;

  public iPhoneBuyer(Person person) {
    this.person = person;
  }

  @Override
  public boolean canAfford(iPhone phone) {
    return person.getBudget() >= phone.getPrice();
  }

  @Override
  public void purchase(iPhone phone) {
    if (canAfford(phone)) {
      System.out.println(person.getName() + " купил " + phone.getModel() + " с " + phone.getStorage() + " за " + phone.getPrice() + " тенге.");
    } else {
      System.out.println(person.getName() + " не может купить, нужно еще накопить на " + phone.getModel() + ".");
    }
  }
}
