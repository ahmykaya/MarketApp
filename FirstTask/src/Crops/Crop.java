package Crops;

public abstract class Crop {

   private String name;
   private int weight;
   private String cultivatedSeason;
   private String type;
   private int IDcropKeeper;



    public Crop(String name, int weight, String cultivatedSeason, String type,int IDcropKeeper) {
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
        this.type=type;
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

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }

    public void setCultivatedSeason(String cultivatedSeason) {
        this.cultivatedSeason = cultivatedSeason;
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

}

