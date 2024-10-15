import java.util.List;
import java.util.ArrayList;
class Store {
  private static Store instance;
  private Buyer buyer;
  private List<Observer> observers = new ArrayList<>();

  private Store(Buyer buyer) {
    this.buyer = buyer;
  }

  public static Store getInstance(Buyer buyer) {
    if (instance == null) {
      instance = new Store(buyer);
    }
    return instance;
  }

  public void AddObserver(Observer observer) {
    observers.add(observer);
  }

  private void NotifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public void AttemptPurchase(Customer customer) {
    iPhone phone = customer.getPhone();
    buyer.purchase(phone);
    NotifyObservers("Phone " + phone.getModel() + " has been purchased.");
  }
}
