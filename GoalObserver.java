// Observer pattern for notifying when goals are achieved -Meirzhan
interface GoalObserver {
  void onGoalAchieved(Goal goal);
}

class GoalNotifier implements GoalObserver {
  @Override
  public void onGoalAchieved(Goal goal) {
    System.out.println("Notification: Goal '" + goal.getName() + "' has been achieved!");
  }
}

//BankAPI Adapter -Kadyrulan
class BankAPIAdapter implements GoalObserver {
  private BankAPI bankAPI;

  public BankAPIAdapter(BankAPI bankAPI) {
    this.bankAPI = bankAPI;
  }

  @Override
  public void onGoalAchieved(Goal goal) {
    double availableBalance = bankAPI.getAvailableBalance();
    if (availableBalance >= goal.getTargetAmount()) {
      System.out.println("Bank: Sufficient funds available for your goal.");
      bankAPI.transferFunds(goal.getTargetAmount());
      System.out.println("Bank: Funds transferred to your savings goal.");
    } else {
      System.out.println("Bank: Insufficient funds in your bank account.");
    }
  }
}
