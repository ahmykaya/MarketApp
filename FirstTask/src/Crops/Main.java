package Crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.StreamSupport;

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
            System.out.println("3: Buy a fruit crop");//done
            System.out.println("4: Sell a fruit crop");//done
            System.out.println("5: Remove a fruit from a store");//done
            System.out.println("6: Remove a crop from a supplier");//done
            System.out.println("7: Add Crop");// yarım oldu
            System.out.println("8: Show remaining budget");
            System.out.println("9: Show remaining capacity");
            System.out.println("0: Quit");//done
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
                        System.out.println(supplier.getName() + " "+" ID:" + supplier.getID() + " Budget:" + " " + supplier.getBudget() + " ");
                    });


                    System.out.println("Select a supplier ");
                    Scanner supplierID = new Scanner(System.in);
                    int supplierid = supplierID.nextInt();
                    final Supplier[] mysupplier = new Supplier[1];
                    Supplier supplier1 = suppliersList.stream().filter(supplier -> supplier.getID() == supplierid).findFirst().get();


                    System.out.println("Select a crop ");

                    storeList.forEach(store -> {
                        store.fruitList.forEach(fruit1 -> {
                            System.out.println("Store: " + store.getName() + " Fruit Name: " + fruit1.getName() + " Price: " + fruit1.getPrice());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc = new Scanner(System.in);
                    String selectedmagaza = sc.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc1 = new Scanner(System.in);
                    String selectedurun = sc1.nextLine();


                    AtomicReference<Fruit> mf = new AtomicReference<>();
                    storeList.forEach(store -> {
                        if (selectedmagaza.equals(store.getName())){
                            store.fruitList.forEach(fruit1 -> {
                                if(fruit1.getName().equals(selectedurun)){
                                    supplier1.cropList.add(fruit1);
                                    mf.set(fruit1);
                                    System.out.println();
                                }

                            });
                        }
                        store.fruitList.remove(mf.get());

                    });


                    break;
                case 4:
                    System.out.println("Sell a fruit crop: ");
                    storeList.forEach(store -> {
                        store.fruitList.forEach(fruit1 -> {
                            System.out.println("Store: " + store.getName() + " Fruit Name: " + fruit1.getName() + " Price: " + fruit1.getPrice());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc4 = new Scanner(System.in);
                    String selectedmagaza2 = sc4.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc5 = new Scanner(System.in);
                    String selectedurun2 = sc5.nextLine();

                    suppliersList.forEach(supplier -> {
                        System.out.println(supplier.getName() + " "+" ID:" + supplier.getID() + " Budget:" + " " + supplier.getBudget() + " ");
                    });

                    System.out.println("Id sec");
                    Scanner sc6 = new Scanner(System.in);
                    int selectedsupplier = sc6.nextInt();

                    AtomicReference<Crop> mf4 = new AtomicReference<>();
                    suppliersList.forEach(supplier -> {
                        if (sc6.equals(supplier.getID())){
                            supplier.cropList.forEach(crop -> {
                                if (crop.getName().equals(selectedsupplier)){
                                    mf4.set(crop);
                                }
                            });
                        }
                    });

                    break;
                case 5:
                    System.out.println("Remove a fruit from a store: ");
                    storeList.forEach(store -> {
                        store.fruitList.forEach(fruit1 -> {
                            System.out.println("Store: " + store.getName() + " Fruit Name: " + fruit1.getName() + " Price: " + fruit1.getPrice());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc3 = new Scanner(System.in);
                    String selectedmagaza1 = sc3.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc2 = new Scanner(System.in);
                    String selectedurun1 = sc2.nextLine();

                    AtomicReference<Fruit> mf2 = new AtomicReference<>();
                    storeList.forEach(store -> {
                        if (selectedmagaza1.equals(store.getName())){
                            store.fruitList.forEach(fruit1 -> {
                                if(fruit1.getName().equals(selectedurun1)){
                                    mf2.set(fruit1);
                                }
                            });
                        }
                        store.fruitList.remove(mf2.get());
                    });

                    break;
                case 6:
                    System.out.println("Remove a crop from a supplier: ");
                    suppliersList.forEach(supplier -> {
                        supplier.cropList.forEach(crop -> {
                            System.out.println("Supplier: " +supplier.getName() + " ID: " + supplier.getID() + " Budget: " + supplier.getBudget() + " Type" + " " +crop.getType()+ " " +   " "+crop.getName() );
                        });
                    });

                    System.out.println("Store sec");
                    Scanner suppliersec = new Scanner(System.in);
                    String secsupp = suppliersec.nextLine();

                    System.out.println("urunu sec");
                    Scanner urunsec = new Scanner(System.in);
                    String urunsec1 = urunsec.nextLine();

                    AtomicReference<Crop> mf3 = new AtomicReference<>();
                    suppliersList.forEach(store -> {
                        if (secsupp.equals(store.getName())){
                            store.cropList.forEach(crop -> {
                                if(crop.getName().equals(urunsec1)){
                                    mf3.set(crop);
                                }
                            });
                        }
                        store.cropList.remove(mf3.get());
                    });
                    break;
                case 7:
                    System.out.println("Add Crop: ");
                    Scanner newCrop = new Scanner(System.in);
                    Crop c;
                    Store s1 ;
                    Supplier sup = null;


                    System.out.println("Name gir: ");
                    String  name = newCrop.nextLine();

                    System.out.println("Weight gir: ");
                    int weight = newCrop.nextInt();

                    System.out.println("CultivatedSeason gir :  (Winter, Autumn , Spring , Summer)");
                    Scanner cultivatedSeason = new Scanner(System.in);
                    String cultivatedSeason1 = cultivatedSeason.nextLine();

                    System.out.println("Taste: ");
                    Scanner taste = new Scanner(System.in);
                    String taste1 = taste.nextLine();

                    System.out.println("Price: ");
                    Scanner price = new Scanner(System.in);
                    int price1 = price.nextInt();

                    System.out.println("Type:   (Fruit , Vegetables)");
                    Scanner type = new Scanner(System.in);
                    String type1 = type.nextLine();

                    System.out.println("IDcropKeeper:  (1133,1298,1122,1429,5343,5967) ");
                    Scanner Id = new Scanner(System.in);
                    int IDcropKeeper1 = Id.nextInt();

                    Fruit fruit = null;
                    if (type.equals("Fruit")){
                     fruit = new Fruit(name ,weight,cultivatedSeason1,taste1,price1,type1,IDcropKeeper1);

                    }

                    Vegetable vegetable = null;
                    if (type.equals("Vegetable")){
                        vegetable = new Vegetable(name,weight,cultivatedSeason1,type1,IDcropKeeper1);
                    }

                    Fruit finalFruit = fruit;
                    suppliersList.forEach(supplier -> {
                        if (IDcropKeeper1 == supplier.getID()){
                            supplier.cropList.add(finalFruit);
                        }
                        System.out.println(newCrop);
                    });

                    Vegetable finalVegetable = vegetable;
                    suppliersList.forEach(supplier -> {
                        if (IDcropKeeper1 == supplier.getID()){
                            supplier.cropList.add(finalVegetable);
                        }
                        System.out.println(finalVegetable);
                    });

                    break;
                case 8:
                    System.out.println("Show remaining budget: ");
                    Supplier supplier2 = null;
                    supplier2.getBudget() = sup.getBudget() - selectedurun.;



//                    System.out.println("Id sec");
//                    Scanner sc7 = new Scanner(System.in);
//                    int selectedsupplier1 = sc7.nextInt();
//
//
//
//                    AtomicReference<Crop> mf5 = new AtomicReference<>();
//                    suppliersList.forEach(supplier -> {
//                        if (sc7.equals(supplier.getID())){
//                            supplier.cropList.forEach(crop -> {
//                                if (crop.getName().equals(selectedsupplier1)){
//                                    mf5.set(crop);
//
//                                }
//                            });
//                        }
//                    });

//                    System.out.println("Supplier id gir: ");
//                    Scanner budget = new Scanner(System.in);
//                    int budget1 = budget.nextInt();
//                    suppliersList.forEach(supplier -> {
//                        if (budget1 == supplier.getID()) {
//                            if (supplier.cropList.add(redApple)) {
//                                int i = 0;
//                                i=supplier.getBudget() - redApple.getPrice();
//                            }
//
//                        }
//
//                    });

//                    System.out.printf("ArazMeyve: " + String.valueOf(arazMeyve.getBudget()));
//                    System.out.printf("\n");
//                    System.out.printf("AylarTarim: " + String.valueOf(aylarTarim.getBudget()));
//                    System.out.printf("\n");
//                    System.out.printf("HasanBey: " + String.valueOf(hasanBey.getBudget()));
//                    System.out.printf("\n");
//                    System.out.printf("ZehraCiftci: " + String.valueOf(zehraCiftci.getBudget()));

                    break;
                case 9:
                    System.out.println("Show remaining capacity: ");
//                    System.out.println("ArazMeyve New Capacity: " +arazMeyve.);
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

    public static void newBudget(Supplier s, Fruit f){

        int i= s.getBudget() - f.getPrice();
        System.out.println(i);

    }

    public static void newCrop(Crop c){
        Scanner crop = new Scanner(System.in);
        crop.next();
        System.out.println(c);
    }





}