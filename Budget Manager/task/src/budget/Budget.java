package budget;

import java.util.HashMap;
import java.util.Scanner;

public class Budget {
    private double balance;
    private HashMap<Integer, TypesOfProducts> book;

    public Budget() {
        book = new HashMap<>();
        book.put(1, TypesOfProducts.FOOD);
        book.put(2, TypesOfProducts.CLOTHES);
        book.put(3, TypesOfProducts.ENTERTAINMENT);
        book.put(4, TypesOfProducts.OTHER);
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public HashMap<Integer, TypesOfProducts> getBook() {
        return book;
    }

    public void setBook(HashMap<Integer, TypesOfProducts> book) {
        this.book = book;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public double count() {
        double sum = 0;
        for (int i = 1; i <= 4; i++) {
            sum += book.get(i).getSum();
        }
        return sum;
    }
}
