# Motivational Piggy Bank Project

## Project Overview

The **Motivational Piggy Bank** is a Java application designed to help users set and track financial goals. Users can create goals, specify target amounts, track monthly savings, and get notified upon reaching their targets. If users save more than required for a goal, the excess funds can either be reallocated to other goals or saved for future use.

## Key Features

1. **Goal Management**:
   - Add, view, and delete savings goals.
   - Track monthly progress towards each goal.
   - Receive notifications when goals are achieved, with any excess funds managed effectively.

2. **Design Patterns Used**:
   - **Prototype Pattern**: Used to clone `Goal` objects, allowing the application to manage goal states individually.
   - **Memento Pattern**: Facilitates saving and restoring the state of goals, so users can revert to previous progress if needed.

3. **Data Persistence**: All goals and savings data are saved, allowing users to continue progress even after restarting the application.

## Project Structure

- **src/Main.java**: The main entry point of the application. Provides a command-line interface for managing goals and tracking savings.
- **Goal.java**: Defines goal attributes and methods to handle goal progress and completion.
- **CustomerMemento.java, CustomerCareTaker.java**: Implements the Memento pattern for saving and restoring goal states.
- **PriceStrategy, Buyer, PurchaseHandler**: Implements budgeting and purchasing strategies, as well as observer patterns for notifications.

## How to Use

1. **Run the Application**:
   - Compile and run `Main.java` to start the application.
   - Follow the prompts to set and manage savings goals.

2. **Add Goals**:
   - Use the CLI to add a goal, specify a target amount, and set monthly savings.
   
3. **Track Progress**:
   - Enter monthly savings updates to see progress towards each goal.
   - The system will notify you when a goal is completed and handle any excess funds appropriately.

## Setup and Compilation

1. **Requirements**: Java 11 or higher.
2. **Compile**:
   ```bash
   javac -d bin src/*.java
