package budget.operations;

import budget.Budget;
import budget.operations.OperationType;

public class AddIncome implements OperationType {
    @Override
    public void execute(Budget budget) {
        System.out.println("Enter income:");
        double value = Double.parseDouble(budget.getInput());
        if (value >= 0) {
            budget.setBalance(budget.getBalance() + value);
        }
    }
}
