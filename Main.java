import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your budget: ");
        double budget = scanner.nextDouble();

        Person person = new Person(name, budget);
        iPhoneFactory phoneFactory = new iPhone15Factory();
        iPhone phone = phoneFactory.createiPhone();
        iPhone clonedPhone = phone.clone();
        Customer customer = new Customer(clonedPhone);
        Buyer buyer = new iPhoneBuyer(person);
        Store store = Store.getInstance(buyer);

        PurchaseHandler budgetCheckHandler = new BudgetCheckHandler(buyer);
        PurchaseHandler finalPurchaseHandler = new FinalPurchaseHandler();
        budgetCheckHandler.setNext(finalPurchaseHandler);

        StockManagementSystem stockSystem = new StockManagementSystem();
        store.AddObserver(stockSystem);

        PurchaseMediator mediator = new PurchaseMediator(store, stockSystem);
        mediator.notify(store, "PurchaseAttempt");

        CustomerCareTaker careTaker = new CustomerCareTaker();
        careTaker.saveState(customer);

        Command purchaseCommand = new PurchaseCommand(store, customer);
        purchaseCommand.execute();

        careTaker.restoreState(customer);
        System.out.println("Restored state: " + customer.getPhone().getModel());

        budgetCheckHandler.handle(customer, clonedPhone);

        scanner.close();
    }
}