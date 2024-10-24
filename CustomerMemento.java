class CustomerMemento {
  private iPhone phone;

  public CustomerMemento(iPhone phone) {
    this.phone = phone;
  }

  public iPhone getSavedPhone() {
    return phone;
  }
}

class Customer {
  private iPhone phone;

  public Customer(iPhone phone) {
    this.phone = phone;
  }

  public iPhone getPhone() {
    return phone;
  }

  public void setPhone(iPhone phone) {
    this.phone = phone;
  }

  public CustomerMemento save() {
    return new CustomerMemento(phone);
  }

  public void restore(CustomerMemento memento) {
    this.phone = memento.getSavedPhone();
  }
}
class CustomerCareTaker {
  private CustomerMemento memento;

  public void saveState(Customer customer) {
    memento = customer.save();
  }

  public void restoreState(Customer customer) {
    customer.restore(memento);
  }
}
