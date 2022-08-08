package Crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supplier implements CropKeeper {

    private String name;
    private int ID;
    private int budget;
    ArrayList<Crop> cropList = new ArrayList<>();
    public static int supplierID(int id) {
        String formatID = String.format("1%s",id);
        int fortatedid = Integer.parseInt(formatID);
        return fortatedid;
    }

    public Supplier(String name, int ID, int budget) {
        this.name = name;
        this.ID = supplierID(ID);
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

    @Override
    public void howToStore(Crop c) {
        if (c.getType() == "Fruit"){
            System.out.printf("Fruit in refrigerators");
        }else if (c.getType() == "Vegetables"){
            System.out.printf("Vegetables in the field booths");
        }
    }

    public void buyCrop(Crop c , Fruit f) throws Exception{
        if (this.budget>= c.getWeight()*f.getPrice()){

        }else {
            throw new Exception("SupplierHasNotEnougMoneyException");
        }
    }

    public void sellCrop(Crop c)throws Exception{ // hata var bunda
        if (this.cropList.equals(c)){
            cropList.remove(c);
        }else {
            throw new Exception("FruitNotFoundException");
        }
    }

    public void newBudget(Fruit f){
        cropList.forEach(crop -> {
            this.budget = this.getBudget() - (f.getWeight() * f.getPrice());
            System.out.println(this.budget);
        });
    }
}