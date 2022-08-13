package Crops;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws IOException {


        List<String> hepsi = new ArrayList<>();


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


        hepsi.add(String.valueOf(redApple));
        hepsi.add(String.valueOf(orangeF));
        hepsi.add(String.valueOf(kiwi));
        hepsi.add(String.valueOf(greenAppleA));
        hepsi.add(String.valueOf(orangeH));
        hepsi.add(String.valueOf(greenAppleM));
        hepsi.add(String.valueOf(banana));
        hepsi.add(String.valueOf(parsley));
        hepsi.add(String.valueOf(mint));
        hepsi.add(String.valueOf(greenBeans));

        List<Supplier> suppliersList = new ArrayList<>();
        Supplier arazMeyve = new Supplier("ArazMeyve", 133, 1000);
        Supplier aylarTarim= new Supplier("AylarTarim", 298, 1500);
        Supplier hasanBey = new Supplier("HasanBey", 322, 200);
        Supplier zehraCiftci = new Supplier("ZehraCiftci", 429, 1250);

        suppliersList.add(arazMeyve);
        suppliersList.add(aylarTarim);
        suppliersList.add(hasanBey);
        suppliersList.add(zehraCiftci);

        File file1 = new File("supplier.txt");
        if (!file1.exists()){
            file1.createNewFile();
        }

        FileReader fileReader1 = new FileReader(file1);
        String supp1;
        BufferedReader bf1 = new BufferedReader(fileReader1);
        while ((supp1 =bf1.readLine()) !=null){
            System.out.println(supp1);
        }
        bf1.close();

        System.out.println("---------------------------");

        File file2 = new File("crop.txt");
        if (!file2.exists()){
            file2.createNewFile();
        }
        FileReader fileReader2 = new FileReader(file2);
        String supp2;
        BufferedReader bf2 = new BufferedReader(fileReader2);


        bf2.close();

        System.out.println("---------------------------");


        File file3 = new File("store.txt");
        if (!file3.exists()){
            file3.createNewFile();
        }
        FileReader fileReader3 = new FileReader(file3);
        String supp3 = "Migros, 5343, 1000, 12";
        String [] supp6 = supp3.split(",");
        BufferedReader bf3 = new BufferedReader(fileReader3);
        for (String a : supp6){
            System.out.println(a);
        }
        bf3.close();



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
            System.out.println("8: Show remaining budget");//done
            System.out.println("9: Show remaining capacity");//done
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
                        System.out.println(store.getName() + " " + store.getID() + " " +
                                store.getMaxCapacityArea() + " " + store.getKGperSquareMeter());
                        });

                    System.out.println("Select a store ");
                    Scanner storeID = new Scanner(System.in);
                    int storeid = storeID.nextInt();
                    final Store[] mystore = new Store[1];
                    Store store1 = storeList.stream().filter(store -> store.getID() == storeid).findFirst().get();

                    System.out.println("Select a crop ");

                    suppliersList.forEach(supplier -> {
                        supplier.cropList.forEach(crop1 -> {
                            System.out.println("SupplierName: " +supplier.getName()+" " +" " + "Crop name: " + " " +  crop1.getName() + "Price: " + " " + " "  + "Kilo: " + " " + crop1.getWeight()+" " + "ID: " + " " + crop1.getIDcropKeeper());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc4 = new Scanner(System.in);
                    String selectedmagaza4 = sc4.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc2 = new Scanner(System.in);
                    String selectedurun5 = sc2.nextLine();

                    System.out.println("Kac kilo alcan?");
                    Scanner sc5 = new Scanner(System.in);
                    int kilo = sc5.nextInt();

                    AtomicReference<Fruit> mf4 = new AtomicReference<>();
                    suppliersList.forEach(supplier -> {
                        if (selectedmagaza4.equals(supplier.getName())){
                            supplier.cropList.forEach(crop1 -> {
                                if (crop1.getName().equals(selectedurun5)){
                                    if (kilo<=crop1.getWeight()){
                                        store1.fruitList.add((Fruit) crop1);
                                        mf4.set((Fruit) crop1);
                                    }else {
                                        System.out.println("Kilo fazla girdiniz");
                                    }

                                    int a ;
                                    a=crop1.getWeight()-kilo;
                                    System.out.println(crop1.getName() +" "+ a);


                                    int b ;
                                    b = supplier.getBudget() + (kilo*mf4.get().getPrice());
                                    System.out.println(supplier.getName() + " " + b);
                                }



                            });

                        }
                        if (mf4.get().getWeight()<=0){
                            supplier.cropList.remove(mf4.get());
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
                    Scanner sc6 = new Scanner(System.in);
                    String selectedurun1 = sc6.nextLine();

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
                    System.out.println("Meyve mi Sebze mi eklicen?");
                    Scanner newCrop = new Scanner(System.in);
                    String type = newCrop.nextLine();

                    System.out.println("Supplier mi Store mu ?");
                    Scanner newCrop1 = new Scanner(System.in);
                    String type1 = newCrop1.nextLine();


                    if (type1.equals("Supplier")){
                        if (type.equals("Fruit")){
                            System.out.println("Supplier Sec:");
                            Scanner a = new Scanner(System.in);
                            String supplierAdd = a.nextLine();

                            suppliersList.forEach(supplier -> {
                                if (supplierAdd.equals(supplier.getName())){

                                    System.out.println("Name Sec:");
                                    Scanner a1 = new Scanner(System.in);
                                    String supplierAdd1 = a1.nextLine();

                                    System.out.println("Weight Sec:");
                                    Scanner a2 = new Scanner(System.in);
                                    int supplierAdd2 = a2.nextInt();

                                    System.out.println("cultivatedSeason Sec:");
                                    Scanner a3 = new Scanner(System.in);
                                    String supplierAdd3 = a3.nextLine();

                                    System.out.println("taste Sec:");
                                    Scanner a4 = new Scanner(System.in);
                                    String supplierAdd4 = a4.nextLine();

                                    System.out.println("price Sec:");
                                    Scanner a5 = new Scanner(System.in);
                                    int supplierAdd5 = a5.nextInt();

                                    System.out.println("type Sec:");
                                    Scanner a6 = new Scanner(System.in);
                                    String supplierAdd6 = a6.nextLine();

                                    System.out.println("IDcropKeeper Sec:" +"\n" +"ArazMeyve : 1133" +"\n" +"AylarTarim : 1298" +"\n" +"HasanBey : 1322" +"\n" +"Zehra Ciftci : 1429"  );
                                    Scanner a7 = new Scanner(System.in);
                                    int supplierAdd7 = a7.nextInt();

                                    System.out.println("Fruit Name:" + " " +supplierAdd1 + " "  +"Weight:" + " " +  supplierAdd2 +" "  + "cultivatedSeason:" + " " +  supplierAdd3 + " "
                                            + "Taste:" + " " +  supplierAdd4 + " " + "Price:" + " " + supplierAdd5
                                            +" " +  "Type:" + " " +  supplierAdd6 + " " + "IdCropKeeper:" + " " +  supplierAdd7);

                                    Fruit addCrop = new Fruit(supplierAdd1,supplierAdd2,supplierAdd3,supplierAdd4,supplierAdd5,supplierAdd6,supplierAdd7);
                                    Crop  c;
                                    suppliersList.forEach(supplier2 -> {
                                        if (supplierAdd.equals(supplier2.getName())){
                                            supplier2.cropList.add(addCrop);
                                            System.out.println(supplier2.cropList);
                                        }

                                    });



                                }
                            });


                        }

                        if (type.equals("Vegetable")){
                            System.out.println("Supplier Sec:");
                            Scanner a = new Scanner(System.in);
                            String supplierAdd = a.nextLine();

                            suppliersList.forEach(supplier -> {
                                if (supplierAdd.equals(supplier.getName())){

                                    System.out.println("Name Sec:");
                                    Scanner a1 = new Scanner(System.in);
                                    String supplierAdd1 = a1.nextLine();

                                    System.out.println("Weight Sec:");
                                    Scanner a2 = new Scanner(System.in);
                                    int supplierAdd2 = a2.nextInt();

                                    System.out.println("cultivatedRegion Sec:");
                                    Scanner a3 = new Scanner(System.in);
                                    String supplierAdd3 = a3.nextLine();

                                    System.out.println("type Sec:");
                                    Scanner a6 = new Scanner(System.in);
                                    String supplierAdd6 = a6.nextLine();

                                    System.out.println("IDcropKeeper Sec:" +"\n" +"ArazMeyve : 1133" +"\n" +"AylarTarim : 1298" +"\n" +"HasanBey : 1322" +"\n" +"Zehra Ciftci : 1429"  );
                                    Scanner a7 = new Scanner(System.in);
                                    int supplierAdd7 = a7.nextInt();

                                    System.out.println("Fruit Name:" + " " +supplierAdd1 + " "  +"Weight:" + " " +  supplierAdd2 +" "  + "cultivatedRegion:" + " " +  supplierAdd3 + " "
                                            + "Type:" + " " +  supplierAdd6 + " " + "IdCropKeeper:" + " " +  supplierAdd7);

                                    Vegetable newVegg = new Vegetable(supplierAdd1,supplierAdd2,supplierAdd3,supplierAdd6,supplierAdd7);

                                    suppliersList.forEach(supplier2 -> {
                                        supplier2.cropList.add(newVegg);
                                        System.out.println(supplier2.cropList);
                                    });


                                }
                            });



                        }
                    } else if (type1.equals("Store")) {
                        if (type.equals("Fruit")){
                            System.out.println("Supplier Sec:");
                            Scanner a = new Scanner(System.in);
                            String storeAdd = a.nextLine();

                            storeList.forEach(store -> {
                                if (storeAdd.equals(store.getName())){

                                    System.out.println("Name Sec:");
                                    Scanner a1 = new Scanner(System.in);
                                    String supplierAdd1 = a1.nextLine();

                                    System.out.println("Weight Sec:");
                                    Scanner a2 = new Scanner(System.in);
                                    int supplierAdd2 = a2.nextInt();

                                    System.out.println("cultivatedSeason Sec:");
                                    Scanner a3 = new Scanner(System.in);
                                    String supplierAdd3 = a3.nextLine();

                                    System.out.println("taste Sec:");
                                    Scanner a4 = new Scanner(System.in);
                                    String supplierAdd4 = a4.nextLine();

                                    System.out.println("price Sec:");
                                    Scanner a5 = new Scanner(System.in);
                                    int supplierAdd5 = a5.nextInt();

                                    System.out.println("type Sec:");
                                    Scanner a6 = new Scanner(System.in);
                                    String supplierAdd6 = a6.nextLine();

                                    System.out.println("IDcropKeeper Sec:" +"\n" +"ArazMeyve : 1133" +"\n" +"AylarTarim : 1298" +"\n" +"HasanBey : 1322" +"\n" +"Zehra Ciftci : 1429"  );
                                    Scanner a7 = new Scanner(System.in);
                                    int supplierAdd7 = a7.nextInt();

                                    System.out.println("Fruit Name:" + " " +supplierAdd1 + " "  +"Weight:" + " " +  supplierAdd2 +" "  + "cultivatedSeason:" + " " +  supplierAdd3 + " "
                                            + "Taste:" + " " +  supplierAdd4 + " " + "Price:" + " " + supplierAdd5
                                            +" " +  "Type:" + " " +  supplierAdd6 + " " + "IdCropKeeper:" + " " +  supplierAdd7);

                                    Fruit addCrop = new Fruit(supplierAdd1,supplierAdd2,supplierAdd3,supplierAdd4,supplierAdd5,supplierAdd6,supplierAdd7);
                                    Crop  c;
                                    storeList.forEach(store2 -> {
                                        store2.fruitList.add(addCrop);
                                        System.out.println(store2.fruitList);
                                    });


                                }
                            });


                        }else {
                            System.out.println("Sebze Eklenmiyor");
                        }
}



                    break;
                case 8:
                    System.out.println("Show remaining budget: ");

                    suppliersList.forEach(supplier -> {
                        System.out.println(supplier.getName() + " "+" ID:" + supplier.getID() + " Budget:" + " " + supplier.getBudget() + " ");
                    });


                    System.out.println("Select a supplier ");
                    Scanner supplierID1 = new Scanner(System.in);
                    int supplierid1 = supplierID1.nextInt();
                    final Supplier[] mysupplier1 = new Supplier[1];
                    Supplier supplier2 = suppliersList.stream().filter(supplier -> supplier.getID() == supplierid1).findFirst().get();


                    System.out.println("Select a crop ");

                    storeList.forEach(store -> {
                        store.fruitList.forEach(fruit1 -> {
                            System.out.println("Store: " + store.getName() + " Fruit Name: " + fruit1.getName() + " Price: " + fruit1.getPrice());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sc7 = new Scanner(System.in);
                    String selectedmagaza3 = sc7.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc8 = new Scanner(System.in);
                    String selectedurun4 = sc8.nextLine();


                    AtomicReference<Fruit> mf5 = new AtomicReference<>();
                    storeList.forEach(store -> {
                        if (selectedmagaza3.equals(store.getName())){
                            store.fruitList.forEach(fruit1 -> {
                                if(fruit1.getName().equals(selectedurun4)){
                                    supplier2.cropList.add(fruit1);
                                    mf5.set(fruit1);
                                    System.out.println();
                                }

                            });
                        }
                        int newbudget = 0;
                        if (supplier2.getBudget()-(mf5.get().getPrice()*mf5.get().getWeight()) >0){
                             newbudget = supplier2.getBudget()-(mf5.get().getPrice()*mf5.get().getWeight());

                        int a = supplier2.getBudget();
                        System.out.println("Name: " + supplier2.getName() + "New Budget: " + newbudget);
                            store.fruitList.remove(mf5.get());

                        }else {
                            System.out.println("Alamazsiniz");
                        }


                    });
                    break;
                case 9:
                    System.out.println("Show remaining capacity: ");
                    storeList.forEach(store -> {
                        System.out.println(store.getName() + " " + store.getID() + " " +
                                store.getMaxCapacityArea() +" " +store.getUsedCapacityArea() + " " + store.getKGperSquareMeter());
                        });

                    System.out.println("Select a store ");
                    Scanner storeID1 = new Scanner(System.in);
                    int storeid1 = storeID1.nextInt();
                    final Store[] mystore1 = new Store[1];
                    Store store11 = storeList.stream().filter(store -> store.getID() == storeid1).findFirst().get();

                    System.out.println("Select a crop ");

                    suppliersList.forEach(supplier -> {
                        supplier.cropList.forEach(crop1 -> {
                            System.out.println("SupplierName: " +supplier.getName()+" " +" " + "Crop name: " +crop1.getName() + "ID: " + " " + crop1.getIDcropKeeper());
                        });
                    });

                    System.out.println("magazayi sec");
                    Scanner sca = new Scanner(System.in);
                    String selectedmagaza9 = sca.nextLine();

                    System.out.println("Urunu sec");
                    Scanner sc9 = new Scanner(System.in);
                    String selectedurun9 = sc9.nextLine();

                    AtomicReference<Fruit> mf0 = new AtomicReference<>();
                    suppliersList.forEach(supplier -> {
                        if (selectedmagaza9.equals(supplier.getName())){
                            supplier.cropList.forEach(crop1 -> {
                                if (crop1.getName().equals(selectedurun9)){
                                    store11.fruitList.add((Fruit) crop1);
                                    mf0.set((Fruit) crop1);

                                }
                            });
                        }
                        int newCapacity;
                        newCapacity = store11.getMaxCapacityArea()-(store11.getUsedCapacityArea()+(mf0.get().getWeight()*store11.getKGperSquareMeter()));
                        System.out.println(newCapacity);

                        int a;
                        a=store11.getMaxCapacityArea();
                        if (a-newCapacity>=0){
                            supplier.cropList.remove(mf0.get());
                        }else {
                            System.out.println("Yeterli yeriniz yok.");
                        }


                    });

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

    public static void sellFruitSupplier(String fruitsell,String supplierName, List<Supplier> supplierList) throws Exception{

        //for each ile supplier ve store döncem bunu döndüğümden stoere id hangisi eşitse bunu alıcam ve o id den o fruiti silcem
        supplierList.forEach(supplier -> {
            if (supplierName.equals(supplier.getName())){
                supplier.cropList.remove(fruitsell);
            }
        });

    }

    public static void sellFruitStore(String storesell,String storeName,List<Store> storeList) throws Exception{

        //for each ile supplier ve store döncem bunu döndüğümden stoere id hangisi eşitse bunu alıcam ve o id den o fruiti silce

        storeList.forEach(store -> {
            if (storeName.equals(store.getName())){
                store.fruitList.remove(storesell);
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