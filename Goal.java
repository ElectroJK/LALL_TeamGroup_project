//Prototype pattern for clonning -Meirzhan
class Goal implements Cloneable {
  private String name;
  private double targetAmount;
  private double savedAmount;

  public Goal(String name, double targetAmount) {
    this.name = name;
    this.targetAmount = targetAmount;
    this.savedAmount = 0;
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

  public boolean addFunds(double amount) {
    if (savedAmount + amount >= targetAmount) {
      double excess = savedAmount + amount - targetAmount;
      savedAmount = targetAmount;
      System.out.println("Good job! You've reached your goal for " + name + "!");
      if (excess > 0) {
        System.out.println("Excess amount of " + excess + " will be returned to you.");
      }
      return true;
    } else {
      savedAmount += amount;
      System.out.println("Way to go! You have saved " + savedAmount + " out of " + targetAmount + " for " + name + ".");
      return false;
    }
  }

  public void withdrawFunds(double amount) {
    if (amount <= savedAmount) {
      savedAmount -= amount;
      System.out.println("You've withdrawn " + amount + ". Keep saving for your goal: " + name + "!");
    } else {
      System.out.println("Insufficient funds for this goal.");
    }
  }

  // Cloning (Prototype Pattern) -Meirzhan
  @Override
  protected Goal clone() {
    try {
      return (Goal) super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return name + ": Saved = " + savedAmount + ", Target = " + targetAmount;
  }

  // Memento class saving -Meirzhan
  public GoalMemento save() {
    return new GoalMemento(name, targetAmount, savedAmount);
  }

  public void restore(GoalMemento memento) {
    this.name = memento.getName();
    this.targetAmount = memento.getTargetAmount();
    this.savedAmount = memento.getSavedAmount();
  }
}
