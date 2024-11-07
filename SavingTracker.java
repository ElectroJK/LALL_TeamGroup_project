import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Singleton pattern for the main tracker -Kadyrulan
class SavingsTracker {
    private static SavingsTracker instance;
    private List<Goal> goals = new ArrayList<>();
    private List<GoalObserver> observers = new ArrayList<>();
    private String userName;
    private static final double MAX_AMOUNT = 1_000_000_000_000.0;

    private SavingsTracker(String userName) {
        this.userName = userName;
    }

    public static SavingsTracker getInstance(String userName) {
        if (instance == null) {
            instance = new SavingsTracker(userName);
        }
        return instance;
    }

    public void addObserver(GoalObserver observer) {
        observers.add(observer);
    }

    private void notifyGoalAchieved(Goal goal) {
        for (GoalObserver observer : observers) {
            observer.onGoalAchieved(goal);
        }
    }

    public void addGoal(GoalFactory factory, String name, double amount) {
        if (amount > MAX_AMOUNT) {
            System.out.println("Error: The target amount exceeds the maximum limit of " + MAX_AMOUNT + ".");
            return;
        }
        Goal goal = factory.createGoal(name, amount);
        goals.add(goal);
        System.out.println("Goal '" + name + "' added with a target of " + amount + ".");
    }

    public void viewGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals set.");
            return;
        }
        System.out.println("Your Goals:");
        for (int i = 0; i < goals.size(); i++) {
            System.out.println((i + 1) + ". " + goals.get(i));
        }
    }

    public void deleteGoal(int index) {
        if (index == 0) return;
        if (index >= 1 && index <= goals.size()) {
            Goal goalToDelete = goals.get(index - 1);
            System.out.println("Are you sure you want to delete the following goal?");
            System.out.println(goalToDelete);
            System.out.print("Type 'yes' to confirm or 'no' to cancel: ");
            Scanner scanner = new Scanner(System.in);
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Goal '" + goalToDelete.getName() + "' deleted.");
                goals.remove(index - 1);
            } else {
                System.out.println("Goal deletion canceled.");
            }
        } else {
            System.out.println("Invalid goal selection.");
        }
    }



    public void manageGoal(int index) {
        if (index < 1 || index > goals.size()) {
            System.out.println("Invalid goal selection.");
            return;
        }
        Goal goal = goals.get(index - 1);
        Scanner scanner = new Scanner(System.in);
        SavingStrategy strategy = new FixedSavingStrategy();

        while (true) {
            System.out.println("Managing goal: " + goal.getName() + " Saved = " + goal.getSavedAmount() + ", Target = " + goal.getTargetAmount());

            System.out.println("1. Add Funds");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");
            int choice = getValidIntInput(scanner);
            switch (choice) {
                case 1:
                    System.out.print("Enter base amount to add or 0 to cancel: ");
                    double baseAmount = getValidDoubleInput(scanner);
                    if (baseAmount == 0) return;
                    double addAmount = strategy.calculateAmountToAdd(baseAmount);
                    if (goal.addFunds(addAmount)) {
                        notifyGoalAchieved(goal);

                        System.out.print("Would you like to delete the goal '" + goal.getName() + "' now? (yes/no): ");
                        String deleteConfirmation = scanner.nextLine();
                        if (deleteConfirmation.equalsIgnoreCase("yes")) {
                            deleteGoal(index);
                        }
                        return;
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw or 0 to cancel: ");
                    double withdrawAmount = getValidDoubleInput(scanner);
                    if (withdrawAmount == 0) return;
                    goal.withdrawFunds(withdrawAmount);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    public int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double input = Double.parseDouble(scanner.nextLine());
                if (input < 0) {
                    System.out.println("Error: Amount cannot be negative.");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String getUserName() {
        return userName;
    }
}
