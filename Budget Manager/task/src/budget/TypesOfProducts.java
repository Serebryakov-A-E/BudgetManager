package budget;

import java.util.ArrayList;

public enum TypesOfProducts {
    FOOD("Food", 0, new ArrayList<String>()),
    CLOTHES("Clothes", 0, new ArrayList<String>()),
    ENTERTAINMENT("Entertainment", 0, new ArrayList<String>()),
    OTHER("Other", 0, new ArrayList<String>());

    private String name;
    private double sum;
    private ArrayList<String> list;

    TypesOfProducts(String name, double sum, ArrayList<String> list) {
        this.name = name;
        this.sum = sum;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void addSum(double cost) {
        this.sum += cost;
    }

    public ArrayList<String> getList() {
        return list;
    }
}
