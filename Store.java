class Store {
  private Buyer buyer;

  public Store(Buyer buyer) {
    this.buyer = buyer;
  }

  public void attemptPurchase(Customer customer) {
    iPhone phone = customer.getPhone();
    buyer.purchase(phone);
  }
}
