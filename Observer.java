interface Observer {
  void update(String message);
}
class StockManagementSystem implements Observer {
  @Override
  public void update(String message) {
    System.out.println("Stock system received notification: " + message);
  }

  public void updateStock() {
    System.out.println("Stock updated.");
  }
}
