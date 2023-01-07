package budget.operations;

import budget.Budget;
import budget.operations.OperationType;

import java.util.Scanner;

public class AddPurchase implements OperationType {
    @Override
    public void execute(Budget budget) {
        while (true) {
            chooseAction();
            int action = Integer.parseInt(getInput());
            if (action == 0) {
                System.exit(0);
                return;
            }
            if (action < 1 || action > 4) {
                break;
            }
            addPurchase(action, budget);
        }

    }
    private void addPurchase(int action, Budget budget) {
        System.out.println("\nEnter purchase name:");
        String product = getInput();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(getInput());

        String priceS = String.format("%.2f", price);

        budget.getBook().get(action).getList().add(product + " $" + priceS);
        budget.getBook().get(action).addSum(price);
        System.out.println("Purchase was added!\n");
        budget.setBalance(budget.getBalance() - price);
    }
    private void chooseAction() {
        System.out.println("Choose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
