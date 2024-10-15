interface Command {
    void execute();
}

class PurchaseCommand implements Command {
    private Store store;
    private Customer customer;

    public PurchaseCommand(Store store, Customer customer) {
        this.store = store;
        this.customer = customer;
    }

    @Override
    public void execute() {
        store.AttemptPurchase(customer);
    }
}