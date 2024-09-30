public class Main {
    public static void main(String[] args) {
        Person person = new Person("Джэк", 1);
        iPhone phone = new iPhone15();
        Buyer buyer = new iPhoneBuyer(person);
        Store store = new Store(buyer);

        store.attemptPurchase(phone);
    }
}
