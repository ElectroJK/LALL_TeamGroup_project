//memento pattern that can be restored if needed (-Meirzhan)
class GoalMemento {
  private final String name;
  private final double targetAmount;
  private final double savedAmount;

  public GoalMemento(String name, double targetAmount, double savedAmount) {
    this.name = name;
    this.targetAmount = targetAmount;
    this.savedAmount = savedAmount;
  }

  public String getName() {
    return name;
  }

  public double getTargetAmount() {
    return targetAmount;
  }

  public double getSavedAmount() {
    return savedAmount;
  }
}
