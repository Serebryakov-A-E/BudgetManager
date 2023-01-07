package budget.operations;

import budget.Budget;

public class OperationManager {
    private static OperationManager instance;
    public static OperationManager getInstance() {
        if (instance == null) {
            instance = new OperationManager();
        }
        return instance;
    }
    private OperationType operation;
    public void setOperation(OperationType operation) {
        this.operation = operation;
    }
    public void execute(Budget budget) {
        operation.execute(budget);
    }
}
