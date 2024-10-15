abstract class PurchaseHandler {
    protected PurchaseHandler next;

    public void setNext(PurchaseHandler next) {
        this.next = next;
    }

    public abstract void handle(Customer customer, iPhone phone);
}

class BudgetCheckHandler extends PurchaseHandler {
    private Buyer buyer;

    public BudgetCheckHandler(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void handle(Customer customer, iPhone phone) {
        if (buyer.CanAfford(phone)) {
            if (next != null) {
                next.handle(customer, phone);
            }
        } else {
            System.out.println("cannot afford " + phone.getModel());
        }
    }
}

class FinalPurchaseHandler extends PurchaseHandler {
    @Override
    public void handle(Customer customer, iPhone phone) {
        System.out.println(customer.getPhone().getModel() + " purchased successfully.");
    }
}