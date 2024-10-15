interface Observer {
  void update(String message);
}

class StockManagementSystem implements Observer {
  @Override
  public void update(String message) {
    System.out.println("Stock Management System notified: " + message);
  }
}
