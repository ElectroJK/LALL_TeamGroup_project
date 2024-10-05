class Customer {
  private iPhone phone;

  public Customer(iPhone phone) {
    this.phone = phone;
  }

  public iPhone getPhone() {
    return phone;
  }

  public String getPhoneStorage() {
    return phone.getStorage();
  }

  public double getPhonePrice() {
    return phone.getPrice();
  }

  public String getPhoneModel() {
    return phone.getModel();
  }

  public void setPhone(iPhone phone) {
    this.phone = phone;
  }
}
