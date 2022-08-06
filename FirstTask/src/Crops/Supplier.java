package Crops;

import java.util.ArrayList;

public class Supplier {

    private String name;
    private int ID;
    private int budget;

    public Supplier(String name, int ID, int budget) {
        this.name = name;
        this.ID = ID;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}