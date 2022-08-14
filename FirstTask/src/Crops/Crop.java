package Crops;

public abstract class Crop {

    private String name;
    private int weight;
    private String type;
    private int IDcropKeeper;



    public Crop(String name, String type, int weight,int IDcropKeeper) {
        this.name = name;
        this.type=type;
        this.weight = weight;
        this.IDcropKeeper=IDcropKeeper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIDcropKeeper() {
        return IDcropKeeper;
    }

    public void setIDcropKeeper(int IDcropKeeper) {
        this.IDcropKeeper = IDcropKeeper;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
