class Customer {
  private iPhone Phone;

  public Customer(iPhone phone) {
    this.Phone = phone;
  }
  public String getPhoneStorage() {
    return Phone.getStorage();
  }
  public double getPhonePrice() {
    return Phone.getPrice();
  }
}
