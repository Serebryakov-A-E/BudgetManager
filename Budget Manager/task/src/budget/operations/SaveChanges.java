package budget.operations;

import budget.Budget;
import budget.operations.OperationType;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveChanges implements OperationType {
    @Override
    public void execute(Budget budget) {
        String path = "purchases.txt";
        File file = new File(path);
        try {
            boolean createdNow = file.createNewFile();
            if (createdNow) {
                System.out.println("Purchases were saved!\n");
            }
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(budget.getBalance());
            budget.getBook().forEach((integer, typesOfProducts) -> {
                printWriter.println(integer);
                printWriter.println(typesOfProducts.getSum());
                printWriter.println(typesOfProducts.getList().size());
                for (String prod : typesOfProducts.getList()) {
                    printWriter.println(prod);
                }
            });
        } catch (IOException e) {
            System.out.printf("An exception occurred %s", e.getMessage());
        }
    }
}
