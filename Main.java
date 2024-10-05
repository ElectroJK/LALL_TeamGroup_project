public class Main {
    public static void main(String[] args) {
        Person person = new Person("Джэк", 600000);

        iPhoneFactory phoneFactory = new iPhone15Factory();
        iPhone phone = phoneFactory.createiPhone();

        Customer customer = new Customer(phone);

        Buyer buyer = new iPhoneBuyer(person);
        Store store = new Store(buyer);

        store.attemptPurchase(customer);
    }
}
