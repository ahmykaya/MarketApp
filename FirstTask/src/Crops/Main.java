package Crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        Fruit redApple = new Fruit("RedApple",45,"winter","sweet",3,"fruit",1133);
        Fruit orangeF = new Fruit("Orange",50,"autumn","sour",4,"fruit",5967);
        Fruit kiwi = new Fruit("Kiwi",10,"autumn","sour",10,"fruit",1133);
        Fruit greenAppleA = new Fruit("GreenApple",25,"winter","sweet",6,"fruit",1133);
        Fruit orangeH = new Fruit("Orange",20,"autumn","sour",4,"fruit",1322);
        Fruit greenAppleM = new Fruit("GreenApple",5,"winter","sweet",6,"fruit",5343);
        Fruit banana = new Fruit("Banana",63,"summer","sweet",12,"fruit",5343);

        Vegetable parsley = new Vegetable("Parsley",25,"Samsun","vegetable",1429);
        Vegetable mint = new Vegetable("Mint",15,"Adana","vegetable",1429);
        Vegetable greenBeans = new Vegetable("GreenBeans",22,"Bursa","vegetable",1322);



        List<Supplier> suppliersList = new ArrayList<>();
        Supplier arazMeyve = new Supplier("ArazMeyve", 133, 1000);
        Supplier aylarTarim= new Supplier("AylarTarim", 298, 1500);
        Supplier hasanBey = new Supplier("HasanBey", 322, 200);
        Supplier zehraCiftci = new Supplier("ZehraCiftci", 429, 1250);

        suppliersList.add(arazMeyve);
        suppliersList.add(aylarTarim);
        suppliersList.add(hasanBey);
        suppliersList.add(zehraCiftci);

        List<Store> storeList = new ArrayList<>();
        Store migros= new Store(5343,"Migros",1000,12);
        Store file= new Store(5967,"File",1200,10);

        storeList.add(migros);
        storeList.add(file);


        arazMeyve.cropList.add(redApple);
        file.fruitList.add(orangeF);
        arazMeyve.cropList.add(kiwi);
        arazMeyve.cropList.add(greenAppleA);
        hasanBey.cropList.add(orangeH);
        migros.fruitList.add(greenAppleM);
        migros.fruitList.add(banana);

        zehraCiftci.cropList.add(parsley);
        zehraCiftci.cropList.add(mint);
        hasanBey.cropList.add(greenBeans);




        int option=0;
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("---------------------------------------");
            System.out.println("MENU");
            System.out.println("1: All Suppliers"); //done
            System.out.println("2: All Stores"); //done
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

            switch (option) {
                case 1:
                    System.out.println("All Suppliers: ");
                    suppliersList.forEach(supplier -> {
                        System.out.println(supplier.getName() + " " + supplier.getID() + " " + supplier.getBudget() + " ");
                    });

                    break;
                case 2:
                    System.out.println("All Stores: ");

                    storeList.forEach(store -> {
                        System.out.println(store.getName() + " " + store.getID() + " " +
                                store.getMaxCapacityArea() + " " + store.getKGperSquareMeter());
                    });
                    break;
                case 3:
                    System.out.println("Buy a fruit crop: "); //supplier storedan satın alır
                    suppliersList.forEach(supplier -> {
                        System.out.println(supplier.getName() + " " + supplier.getID() + " " + supplier.getBudget() + " ");
                    });


                    System.out.println("Select a supplier ");
                    Scanner supplierID = new Scanner(System.in);
                    int supplierid = supplierID.nextInt();
                    final Supplier[] mysupplier = new Supplier[1];
                    suppliersList.forEach(supplier -> {
                        if(supplier.getID() == supplierid){
                            mysupplier[0] = supplier;
                        }

                    });


                    System.out.println("Select a crop ");

                    storeList.forEach(store -> {
                        store.fruitList.forEach(fruit1 -> {
                            System.out.println("Store: " + store.getName() + " Fruit Name: " + fruit1.getName() + " Price: " + fruit1.getPrice());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc = new Scanner(System.in);
                    String selectedmagaza = sc.nextLine();

                    System.out.println("ürünü sec");
                    Scanner sc1 = new Scanner(System.in);
                    String selectedurun = sc1.nextLine();


                    storeList.forEach(store -> {
                        if (selectedmagaza.equals(store.getName())){
                            store.fruitList.forEach(fruit1 -> {
                                if(fruit1.getName().equals(selectedurun)){
                                    mysupplier[0].cropList.add(fruit1);
                                    store.fruitList.remove(fruit1);
                                }
                            });
                        }
                    });

                    //Red apple datası ve storid bilgisi kullnıcının seçtiği üründen gidecek
                    break;
                case 4:
                    System.out.println("Sell a fruit crop: ");
                    Scanner sellFruit = new Scanner(System.in);
                    break;
                case 5:
                    System.out.println("Remove a fruit from a store: ");
                    System.out.printf("Migros: " +migros.availableCapacity());
                    System.out.printf("\n");
                    System.out.printf("File: " + file.availableCapacity());
                    break;
                case 6:
                    System.out.println("Remove a crop from a supplier: ");
                    break;
                case 7:
                    System.out.println("Add Crop: ");
                    //Scanner newCrop = new Scanner(new Crop(" ",," ", " ", ));
                    //System.out.printf(new Crop);
                    break;
                case 8:
                    System.out.println("Show remaining budget: ");
                    System.out.printf("ArazMeyve: " + String.valueOf(arazMeyve.getBudget()));
                    System.out.printf("\n");
                    System.out.printf("AylarTarim: " + String.valueOf(aylarTarim.getBudget()));
                    System.out.printf("\n");
                    System.out.printf("HasanBey: " + String.valueOf(hasanBey.getBudget()));
                    System.out.printf("\n");
                    System.out.printf("ZehraCiftci: " + String.valueOf(zehraCiftci.getBudget()));

                    break;
                case 9:
                    System.out.println("Show remaining capacity: ");
                    break;
                case 0:
                    System.out.println("Quit");
                    System.exit(0);
                    break;


            }
        }




    }



    public static void buyFruit(String fruit,int storeid, List<Supplier> supplierList,List<Store> storeList){

        Fruit newFruit = null;
        //for each ile supplier ve store döncem bunu döndüğümden stoere id hangisi eşitse bunu alıcam ve o id den o fruiti silcem
        supplierList.forEach(supplier -> {
            if (storeid == supplier.getID()){
                supplier.cropList.add(newFruit);
            }
        });

        storeList.forEach(store -> {
            if (storeid == store.getID()){
                store.fruitList.add(newFruit);
            }
        });
    }

    public static void sellFruit(String fruit,int storeid, List<Supplier> supplierList,List<Store> storeList){

        //for each ile supplier ve store döncem bunu döndüğümden stoere id hangisi eşitse bunu alıcam ve o id den o fruiti silcem
        supplierList.forEach(supplier -> {
            if (storeid == supplier.getID()){
                supplier.cropList.remove(fruit);
            }
        });

        storeList.forEach(store -> {
            if (storeid == store.getID()){
                store.fruitList.remove(fruit);
            }
        });
    }

    public void newBudget(){


    }
}







