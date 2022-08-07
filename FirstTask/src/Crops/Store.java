package Crops;

import java.util.ArrayList;

public class Store implements CropKeeper {

    private int ID;
    private String name;
    private int maxCapacityArea;
    private int usedCapacityArea;
    private int KGperSquareMeter=10;
    ArrayList<Fruit> fruitList = new ArrayList<>();

    public Store(int ID, String name, int maxCapacityArea, int usedCapacityArea) {
        this.ID = ID;
        this.name = name;
        this.maxCapacityArea = maxCapacityArea;
        this.usedCapacityArea = usedCapacityArea;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacityArea() {
        return maxCapacityArea;
    }

    public void setMaxCapacityArea(int maxCapacityArea) {
        this.maxCapacityArea = maxCapacityArea;
    }

    public int getUsedCapacityArea() {
        return usedCapacityArea;
    }

    public void setUsedCapacityArea(int usedCapacityArea) {
        this.usedCapacityArea = usedCapacityArea;
    }

    public int getKGperSquareMeter() {
        return KGperSquareMeter;
    }

    public void setKGperSquareMeter(int KGperSquareMeter) {
        this.KGperSquareMeter = KGperSquareMeter;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public int availableCapacity(){
        return this.maxCapacityArea-this.usedCapacityArea;
    }

    public boolean canBeStored(Fruit f){
        if (f.getWeight()>this.KGperSquareMeter){
            return false;
        }else {
            return true;
        }
    }

    public void importCrop(Fruit f) throws Exception{
        if (availableCapacity() >= f.getWeight()){
            this.fruitList.add(f);
        }else {
            throw new Exception("CapacityNotEnoughException");
        }
    }

    public void exportCrop(Fruit f) throws Exception{
        if (this.fruitList.contains(f)){
            this.fruitList.remove(f);
        }else {
            throw new Exception("FruitNotFoundException");
        }


    }

    @Override
    public void howToStore(Crop c) {

    }
}
