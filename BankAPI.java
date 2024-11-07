//Adapter pattern -Kadyrulan
interface BankAPI {
    double getAvailableBalance();
    boolean transferFunds(double amount);
}
class BankAPIImpl implements BankAPI {
    private double balance;

    public BankAPIImpl() {
        this.balance = 1000.00;
    }

    @Override
    public double getAvailableBalance() {
        return balance;
    }

    @Override
    public boolean transferFunds(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
