package Crops;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private String storeName;
    private int storeID;
    private int storeMaxCapacityArea;
    private int storeKgPerSquareMeter;

    public Store(String storeName, int storeID, int storeMaxCapacityArea, int storeKgPerSquareMeter) {
        this.storeName = storeName;
        this.storeID = storeID;
        this.storeMaxCapacityArea = storeMaxCapacityArea;
        this.storeKgPerSquareMeter = storeKgPerSquareMeter;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getStoreMaxCapacityArea() {
        return storeMaxCapacityArea;
    }

    public void setStoreMaxCapacityArea(int storeMaxCapacityArea) {
        this.storeMaxCapacityArea = storeMaxCapacityArea;
    }

    public int getStoreKgPerSquareMeter() {
        return storeKgPerSquareMeter;
    }

    public void setStoreKgPerSquareMeter(int storeKgPerSquareMeter) {
        this.storeKgPerSquareMeter = storeKgPerSquareMeter;
    }
}
