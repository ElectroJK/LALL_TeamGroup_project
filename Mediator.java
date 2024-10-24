interface Mediator {
    void notify(Object sender, String event);
}

class PurchaseMediator implements Mediator {
    private Store store;
    private StockManagementSystem stockSystem;

    public PurchaseMediator(Store store, StockManagementSystem stockSystem) {
        this.store = store;
        this.stockSystem = stockSystem;
    }

    @Override
    public void notify(Object sender, String event) {
        if (event.equals("PurchaseAttempt")) {
            stockSystem.updateStock();
        }
    }
}
