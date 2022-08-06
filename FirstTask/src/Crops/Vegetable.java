package Crops;

public class Vegetable extends Crop implements Comparable<Vegetable> {

    private String cultivatedRegion;

    public Vegetable(String name, int weight, String cultivatedSeason,String cultivatedRegion) {
        super(name, weight, cultivatedSeason);
        this.cultivatedRegion=cultivatedRegion;
    }

    public String getCultivatedRegion() {
        return cultivatedRegion;
    }

    public void setCultivatedRegion(String cultivatedRegion) {
        this.cultivatedRegion = cultivatedRegion;
    }

    public String consumeIt(){
        return "vegetables are cooked";
    }

    public Exception storeIT() throws Exception {
        throw new Exception("CanNotBeStoredException");
    }


    @Override
    public int compareTo(Vegetable o) {
        if (getName()==o.getName()){
            return 0;
        }else {
            return getWeight()-o.getWeight();
        }

    }
}
