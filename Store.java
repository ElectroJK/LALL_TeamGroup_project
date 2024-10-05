class Store {
  private static Store instance;
  private Buyer buyer;
  private Store(Buyer buyer) {
    this.buyer = buyer;
  }
  public static Store getInstance(Buyer buyer) {
    if (instance == null) {
      instance = new Store(buyer);
    }
    return instance;
  }
  public void attemptPurchase(Customer customer) {
    iPhone phone = customer.getPhone();
    buyer.purchase(phone);
  }
}
