package budget;

import budget.operations.*;

import java.util.Scanner;

public class MainMenu {
    OperationManager manager;

    Budget budget;

    public MainMenu() {
         manager = OperationManager.getInstance();
         budget = new Budget();
    }

    public void openMenu() {
        boolean on = true;
        while (on) {
            showMenuActions();
            int input = Integer.parseInt(getInput());
            System.out.println();
            switch (input) {
                case 1:
                    manager.setOperation(new AddIncome());
                    manager.execute(budget);
                    System.out.println("Income was added!");
                    System.out.println();
                    break;
                case 2:
                    manager.setOperation(new AddPurchase());
                    manager.execute(budget);
                    System.out.println();
                    break;
                case 3:
                    manager.setOperation(new ShowPurchases());
                    manager.execute(budget);
                    System.out.println();
                    break;
                case 4:
                    System.out.printf("Balance: $%.2f\n", budget.getBalance());
                    System.out.println();
                    break;
                case 5:
                    manager.setOperation(new SaveChanges());
                    manager.execute(budget);
                    break;
                case 6:
                    manager.setOperation(new LoadBudgetList());
                    manager.execute(budget);
                    break;
                case 7:
                    manager.setOperation(new Analyze());
                    manager.execute(budget);
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.out.println();
                    on = false;
                    break;
                default:
                    System.out.println("неверный ввод");
                    System.out.println();
                    break;
            }
        }
    }



    private void showMenuActions() {
        System.out.print("Choose your action:\n"
                + "1) Add income\n"
                + "2) Add purchase\n"
                + "3) Show list of purchases\n"
                + "4) Balance\n"
                + "5) Save\n"
                + "6) Load\n"
                + "7) Analyze (Sort)\n"
                + "0) Exit\n");
    }
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
