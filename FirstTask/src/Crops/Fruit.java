package Crops;

import java.util.ArrayList;

public class Fruit extends Crop implements Comparable<Fruit>  {

    private String taste;
    private int price;

    public Fruit(String name, int weight, String cultivatedSeason,String taste,int price) {
        super(name, weight, cultivatedSeason);
        this.taste=taste;
        this.price=price;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + getWeight() ;
    }

    public String consumeIt(){
        return "fruits are consumed raw";
    }

    @Override
    public int compareTo(Fruit o) {
        if (getName()==o.getName()){
            return 0;
        }else {
            return getWeight()-o.getWeight();
        }

    }
}
