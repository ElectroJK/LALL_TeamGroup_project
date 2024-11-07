import java.util.Scanner;

//command pattern in main for user interactions -Kadyrulan
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        SavingsTracker tracker = SavingsTracker.getInstance(name);
        GoalFactory factory = new SavingsGoalFactory();

        BankAPI bankAPI = new BankAPIImpl();
        GoalObserver bankAdapter = new BankAPIAdapter(bankAPI);

        tracker.addObserver(bankAdapter);

        tracker.addObserver(new GoalNotifier());

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Goal");
            System.out.println("2. View Goals");
            System.out.println("3. Delete Goal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = tracker.getValidIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter goal name or 0 to cancel: ");
                    String goalName = scanner.nextLine();
                    if (goalName.equals("0")) break;
                    System.out.print("Enter target amount for " + goalName + ": ");
                    double amount = tracker.getValidDoubleInput(scanner);
                    tracker.addGoal(factory, goalName, amount);
                    break;
                case 2:
                    tracker.viewGoals();
                    System.out.print("Select goal to manage or 0 to cancel: ");
                    int goalIndex = tracker.getValidIntInput(scanner);
                    if (goalIndex == 0) break;
                    tracker.manageGoal(goalIndex);
                    break;
                case 3:
                    tracker.viewGoals();
                    System.out.print("Select goal to delete or 0 to cancel: ");
                    int deleteIndex = tracker.getValidIntInput(scanner);
                    tracker.deleteGoal(deleteIndex);
                    break;
                case 4:
                    System.out.println("Goodbye, " + tracker.getUserName() + "!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
