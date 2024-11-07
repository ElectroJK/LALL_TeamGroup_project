// Strategy Pattern for saving method -Kadyrulan
interface SavingStrategy {
    double calculateAmountToAdd(double baseAmount);
}

class FixedSavingStrategy implements SavingStrategy {
    public double calculateAmountToAdd(double baseAmount) {
        return baseAmount;
    }
}