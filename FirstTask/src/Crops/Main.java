package Crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option=0;
        Scanner input = new Scanner(System.in);


            System.out.println("MENU");
            System.out.println("1: All Suppliers");
            System.out.println("2: All Stores");
            System.out.println("3: Buy a fruit crop");
            System.out.println("4: Sell a fruit crop");
            System.out.println("5: Remove a fruit from a store");
            System.out.println("6: Remove a crop from a supplier");
            System.out.println("7: Add Crop");
            System.out.println("8: Show remaining budget");
            System.out.println("9: Show remaining capacity");
            System.out.println("0: Quit");
            System.out.print("Enter your selection : ");

        option = input.nextInt();

        switch (option){
            case 1:
                System.out.println("All Suppliers: ");
                List<Supplier> suppliersList = new ArrayList<>();
                Supplier supplier1 = new Supplier("ArazMeyve", 1133, 1000);
                Supplier supplier2= new Supplier("AylarTarim", 1298, 1500);
                Supplier supplier3 = new Supplier("HasanBey", 1322, 200);
                Supplier supplier4 = new Supplier("ZehraCiftci", 1429, 1250);
                suppliersList.add(supplier1);
                suppliersList.add(supplier2);
                suppliersList.add(supplier3);
                suppliersList.add(supplier4);
                suppliersList.forEach(supplier -> {
                    System.out.println( supplier.getName() + " " +  supplier.getID() + " " +supplier.getBudget() +" ");
                });

                break;
            case 2:
                System.out.println("All Stores: ");
                List<Store> storeList = new ArrayList<>();
                Store store1= new Store("Migros",5343,1000,12);
                Store store2= new Store("File",5967,1200,10);
                storeList.add(store1);
                storeList.add(store2);
                storeList.forEach(store -> {
                    System.out.println(store.getStoreName() + " " + store.getStoreID() + " " +
                            store.getStoreMaxCapacityArea() + " " + store.getStoreKgPerSquareMeter());
                });
                break;
            case 3:
                System.out.println("Buy a fruit crop: ");
                break;
            case 4:
                System.out.println("Sell a fruit crop: ");
                break;
            case 5:
                System.out.println("Remove a fruit from a store: ");
                break;
            case 6:
                System.out.println("Remove a crop from a supplier: ");
                break;
            case 7:
                System.out.println("Add Crop: ");
                break;
            case 8:
                System.out.println("Show remaining budget: ");
                break;
            case 9:
                System.out.println("Show remaining capacity: ");
                break;
            case 0:
                System.out.println("Quit");
                break;


            }


        }

    }

