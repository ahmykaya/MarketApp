package Crops;

public abstract class Crop {

   private String name;
   private int weight;
   private String cultivatedSeason;

    public Crop(String name, int weight, String cultivatedSeason) {
        this.name = name;
        this.weight = weight;
        this.cultivatedSeason = cultivatedSeason;
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
}

