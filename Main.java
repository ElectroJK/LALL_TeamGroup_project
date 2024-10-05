public class Main {
    public static void main(String[] args) {
        Person person = new Person("Джэк", 600000);

        iPhoneFactory phoneFactory = new iPhone15Factory();

        iPhone phone = phoneFactory.createiPhone();

        iPhone clonedPhone = phone.clone();

        Customer customer = new Customer(clonedPhone);

        Buyer buyer = new iPhoneBuyer(person);

        Store store = Store.getInstance(buyer);

        store.attemptPurchase(customer);
    }
}