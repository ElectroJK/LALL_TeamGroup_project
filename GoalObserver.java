//observer pattern for notifying when goals are achieved (-Meirzhan)
interface GoalObserver {
  void onGoalAchieved(Goal goal);
}

class GoalNotifier implements GoalObserver {
  @Override
  public void onGoalAchieved(Goal goal) {
    System.out.println("Notification: Goal '" + goal.getName() + "' has been achieved!");
  }
}
