package budget.operations;

import budget.Budget;
import budget.operations.OperationType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadBudgetList implements OperationType {
    @Override
    public void execute(Budget budget) {
        File file = new File("C:\\Users\\Alexey\\IdeaProjects\\loopshw\\Budget Manager\\Budget Manager\\task\\purchases.txt");
        try (Scanner scanner = new Scanner(file)) {
            budget.setBalance(Double.parseDouble(scanner.nextLine()));
            while (scanner.hasNext()) {
                int typeNum = Integer.parseInt(scanner.nextLine());
                double typeSum = Double.parseDouble(scanner.nextLine());
                budget.getBook().get(typeNum).setSum(typeSum);
                int amountOfProducts = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < amountOfProducts; i++) {
                    budget.getBook().get(typeNum).getList().add(scanner.nextLine());
                }
            }
            System.out.println("Purchases were loaded!\n");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
