package Crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supplier implements CropKeeper {

    private String name;
    private int ID;
    private int budget;
    ArrayList<Crop> cropList = new ArrayList<>();
    public static int supplierID() {
        int a ;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        String formatID;

        formatID = String.format("1%s",a);

        System.out.println(formatID);
        int id = Integer.parseInt(formatID);
        return id;
    }

    public Supplier(String name, int ID, int budget) {
        this.name = name;
        this.ID = supplierID();
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

    public void buyCrop(Crop c) throws Exception{
        if (this.budget>= ){

        }else {
            throw new Exception("SupplierHasNotEnougMoneyException");
        }
    }

    public void sellCrop(Crop c)throws Exception{
        if (){

        }else {
            throw new Exception("FruitNotFoundException");
        }
    }


}