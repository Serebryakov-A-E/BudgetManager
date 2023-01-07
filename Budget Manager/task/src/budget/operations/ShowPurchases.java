package budget.operations;

import budget.Budget;
import budget.operations.OperationType;

public class ShowPurchases implements OperationType {
    @Override
    public void execute(Budget budget) {
        if (budget.getBook().isEmpty()) {
            System.out.println("The purchase list is empty!");
            return;
        }
        while (true) {
            chooseCategory();
            int category = Integer.parseInt(budget.getInput());
            if (category == 6) {
                break;
            }
            if (category == 5) {
                System.out.println("\nAll:");

                showAll(budget);

                String result = String.format("Total sum: $%.2f\n", count(budget));

                System.out.println(result.replace(',', '.'));
                System.out.println();
                continue;
            }
            if (budget.getBook().get(category).getList().isEmpty()) {
                System.out.println();
                System.out.println(budget.getBook().get(category).getName() + ":");
                System.out.println("The purchase list is empty!\n");
                System.out.println();
                continue;
            }
            System.out.println();
            System.out.println(budget.getBook().get(category).getName() + ":");
            budget.getBook().get(category).getList().forEach(System.out :: println);
            String result = String.format("Total sum: $%.2f\n", budget.getBook().get(category).getSum());
            System.out.println(result);
            System.out.println();
        }
    }
    private void showAll(Budget budget) {
        budget.getBook().forEach((integer, typesOfProducts) -> typesOfProducts.getList().forEach(System.out :: println));
    }
    private double count(Budget budget) {
        double sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum += budget.getBook().get(i).getSum();
        }
        return sum;
    }
    private void chooseCategory() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
    }
}
