class Store {
  private Buyer buyer;

  public Store(Buyer buyer) {
    this.buyer = buyer;
  }

  public void attemptPurchase(iPhone phone) {
    buyer.purchase(phone);
  }
}
