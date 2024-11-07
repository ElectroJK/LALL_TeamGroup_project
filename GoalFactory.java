//Factory that create goals -Meirzhan
interface GoalFactory {
  Goal createGoal(String name, double amount);
}

class SavingsGoalFactory implements GoalFactory {
  @Override
  public Goal createGoal(String name, double amount) {
    return new Goal(name, amount);
  }
}
