package budget.operations;

import budget.Budget;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Analyze implements OperationType {
    @Override
    public void execute(Budget budget) {
        boolean on = true;
        while (on) {
            showActions();
            String input = getInput();
            System.out.println();
            switch (input) {
                case "1":
                    ArrayList<String> allList = new ArrayList<>();
                    budget.getBook().forEach((integer, typesOfProducts) -> {
                        allList.addAll(typesOfProducts.getList());
                    });
                    if (allList.isEmpty()) {
                        System.out.println("The purchase list is empty!");
                        break;
                    }
                    allList.sort(new CostComparator());
                    allList.forEach(System.out :: println);
                    System.out.printf("Total sum: $%.2f\n", budget.count());
                    break;
                case "2":
                    ArrayList<String> typesList = new ArrayList<>();
                    budget.getBook().forEach((integer, typesOfProducts) -> {
                        String type;
                        if (typesOfProducts.getSum() == 0) {
                            type = String.format("%s - $%d", typesOfProducts.getName(), 0);
                        } else {
                            type = String.format("%s - $%.2f", typesOfProducts.getName(), typesOfProducts.getSum());
                        }
                        typesList.add(type.replace(',', '.'));
                    });
                    typesList.sort(new CostComparator());
                    System.out.println("Types:");
                    typesList.forEach(System.out :: println);
                    System.out.printf("Total sum: $%.2f\n", budget.count());
                    break;
                case "3":
                    choseType();
                    int type = Integer.parseInt(getInput());

                    ArrayList<String> typeList = new ArrayList<>(budget.getBook().get(type).getList());
                    if (typeList.isEmpty()) {
                        System.out.println("\nThe purchase list is empty!");
                        break;
                    }
                    System.out.println();
                    System.out.println(budget.getBook().get(type).getName() + ":");

                    typeList.sort(new CostComparator());
                    typeList.forEach(System.out :: println);
                    System.out.printf("Total sum: $%.2f\n", budget.getBook().get(type).getSum());
                    break;
                case "4":
                    on = false;
                    return;
                default:
                    System.out.println("wrong operation");
                    break;
            }
            System.out.println();
        }
    }
    private void choseType() {
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other");
    }
    private void showActions() {
        System.out.println("How do you want to sort?");
        System.out.println("1) Sort all purchases");
        System.out.println("2) Sort by type");
        System.out.println("3) Sort certain type");
        System.out.println("4) Back");
    }
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

class CostComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        double first = Double.parseDouble(s1.substring(s1.lastIndexOf('$') + 1));
        double second = Double.parseDouble(s2.substring(s2.lastIndexOf('$') + 1));
        return -Double.compare(first, second);
    }
}