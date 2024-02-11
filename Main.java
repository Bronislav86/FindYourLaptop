/*
+Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
+Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
5 - Поиск
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    //private static Laptop lookingForLaptop = new Laptop(null, null, null, 0, 0, 0);

    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Huawei", "Grey", "IntelCorei5", 15, 16, 1000);
        Laptop laptop2 = new Laptop("ASUS", "White", "IntelCorei3", 17, 8, 512);
        Laptop laptop3 = new Laptop("Hewlet-Packard", "Grey", "IntelCorei7", 16, 4, 256);
        Laptop laptop4 = new Laptop("MSI", "Black", "AMD", 17, 16, 128);
        Laptop laptop5 = new Laptop("VAIO", "Red", "IntelCeleron", 14, 8, 512);
        Laptop laptop6 = new Laptop("VAIO", "White", "IntelCorei5", 15, 16, 512);


        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);

        printSet(laptops);

        List<Object> brendList = new LinkedList<Object>(createBrendList(laptops));
        List<Object> colourList = new LinkedList<Object>(createсColourList(laptops));
        List<Object> cpuList = new LinkedList<Object>(createCPUList(laptops));
        List<Object> displayList = new LinkedList<Object>(createDisplayList(laptops));
        List<Object> ramList = new LinkedList<Object>(createRAMList(laptops));
        List<Object> hddList = new LinkedList<Object>(createHDDList(laptops));

        TreeMap <Integer, Object> brandMap = new TreeMap<>(addToTreeMap(brendList));
        TreeMap <Integer, Object> colourMap = new TreeMap<>(addToTreeMap(colourList));
        TreeMap <Integer, Object> cpuMap = new TreeMap<>(addToTreeMap(cpuList));
        TreeMap <Integer, Object> displayMap = new TreeMap<>(addToTreeMap(displayList));
        TreeMap <Integer, Object> ramMap = new TreeMap<>(addToTreeMap(ramList));
        TreeMap <Integer, Object> hddMap = new TreeMap<>(addToTreeMap(hddList));

        Map<String, TreeMap<Integer, Object>> mapOfAllCaracters = new HashMap<>(createMapOfAllCaracters(brandMap, colourMap, cpuMap, displayMap, ramMap, hddMap));

        System.out.println(mapOfAllCaracters);

        // Map<Integer, String> mapBrands = new HashMap<>();
        // mapBrands.put(1, laptop1.getBrand());
        // mapBrands.put(2, laptop2.getBrand());
        // mapBrands.put(3, laptop3.getBrand());
        // mapBrands.put(4, laptop4.getBrand());
        // mapBrands.put(6, laptop5.getBrand());

        // Map<Integer, String> mapColours = new HashMap<>();
        // mapColours.put(1, "Grey");
        // mapColours.put(2, "Black");
        // mapColours.put(3, "Red");
        // mapColours.put(4, "White");

        // Map<Integer, String> mapCPUtype = new HashMap<>();
        // mapCPUtype.put(1, laptop1.getCPUtype());
        // mapCPUtype.put(2, laptop2.getCPUtype());
        // mapCPUtype.put(3, laptop3.getCPUtype());
        // mapCPUtype.put(4, laptop4.getCPUtype());
        // mapCPUtype.put(4, laptop5.getCPUtype());

        // Map<Integer, Integer> mapDisplays = new HashMap<>();
        // mapDisplays.put(1, 14);
        // mapDisplays.put(2, 15);
        // mapDisplays.put(3, 16);
        // mapDisplays.put(4, 17);

        // Map<Integer, Integer> mapRAM = new HashMap<>();
        // mapRAM.put(1, 4);
        // mapRAM.put(2, 8);
        // mapRAM.put(3, 16);
        // mapRAM.put(4, 24);

        // Map<Integer, Integer> mapHDD = new HashMap<>();
        // mapHDD.put(1, 128);
        // mapHDD.put(2, 256);
        // mapHDD.put(3, 512);
        // mapHDD.put(4, 1000);

        Laptop lookingForLaptop = new Laptop(null, null, null, 0, 0, 0);
        findBy(laptops, lookingForLaptop, mapBrands, mapColours, mapCPUtype, mapDisplays, mapRAM, mapHDD, mapOfAllCaracters);
    }

    private static Map<String, TreeMap<Integer, Object>> createMapOfAllCaracters(TreeMap<Integer, Object> map1,
        TreeMap<Integer, Object> map2, TreeMap<Integer, Object> map3, TreeMap<Integer, Object> map4, TreeMap<Integer, Object> map5,
        TreeMap<Integer, Object> map6) {
        Map<String, TreeMap<Integer, Object>> mapOfAllCaracters = new HashMap<>();
        
        mapOfAllCaracters.put("Бренд", map1);
        mapOfAllCaracters.put("Цвет", map2);
        mapOfAllCaracters.put("Процессор", map3);
        mapOfAllCaracters.put("Экран", map4);
        mapOfAllCaracters.put("ОЗУ", map5);
        mapOfAllCaracters.put("Память", map6);

        return mapOfAllCaracters;
    }

    private static TreeMap<Integer, Object> addToTreeMap(List<Object> list) {
        TreeMap<Integer, Object> treeMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!treeMap.containsValue(list.get(i))){
                treeMap.put(i + 1, list.get(i));
            }
        }
        return treeMap;
    }

    private static List<Object> createBrendList(Set<Laptop> laptops) {
        List<Object> brendList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!brendList.contains(laptop.getBrand())) {
                brendList.add(laptop.getBrand());
            }
        }
        return brendList;
    }

    private static List<Object> createсColourList(Set<Laptop> laptops) {
        List<Object> colourList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!colourList.contains(laptop.getColour())) {
                colourList.add(laptop.getColour());
            }
        }
        return colourList;
    }

    private static List<Object> createCPUList(Set<Laptop> laptops) {
        List<Object> cpuList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!cpuList.contains(laptop.getCPUtype())) {
                cpuList.add(laptop.getCPUtype());
            }
        }
        return cpuList;
    }

    private static List<Object> createDisplayList(Set<Laptop> laptops) {
        List<Object> displayList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!displayList.contains(laptop.getDisplaySize())) {
                displayList.add(laptop.getDisplaySize());
            }
        }
        return displayList;
    }

    private static List<Object> createRAMList(Set<Laptop> laptops) {
        List<Object> ramList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!ramList.contains(laptop.getAmountOfRAM())) {
                ramList.add(laptop.getAmountOfRAM());
            }
        }
        return ramList;
    }

    private static List<Object> createHDDList(Set<Laptop> laptops) {
        List<Object> hddList = new LinkedList<>();
        for (var laptop : laptops) {
            if (!hddList.contains(laptop.getAmountOfHDD())) {
                hddList.add(laptop.getAmountOfHDD());
            }
        }
        return hddList;
    }

    static void findBy(Set<Laptop> laptops, Laptop lookingForLaptop, Map<Integer, String> mapBrands, Map<Integer, String> mapColours, 
        Map<Integer, String> mapCPUtype, Map<Integer, Integer> mapDisplays, Map<Integer, Integer> mapRAM,
        Map<Integer, Integer> mapHDD, Map<String, TreeMap<Integer, Object>> mapOfAllCaracters){

        System.out.println("\nПредставляем вашему вниманию имеющийся ассортимент ноутбуков: \n");
        printSet(laptops);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Чтобы подобрать устройство для себя введите цифру, соответствующую критерию поиска: \n");
        menu();
        boolean work = true;
        while (work) {
            String menuNo  = scanner.nextLine();
                       
            switch (menuNo) {
                case "1":
                    System.out.println("Выберите производителя из списка: ");
                    for (var item : mapOfAllCaracters.get("Бренд").entrySet()) {
                        System.out.printf("%d. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfBrend = Integer.parseInt(scanner.nextLine());                    
                    lookingForLaptop.setBrand((String)mapOfAllCaracters.get("Бренд").get(numOfBrend));
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду: ");
                    break;
                case "2":
                    System.out.println("Выберите цвет из списка: \n");
                    for (var item : mapOfAllCaracters.get("Цвет").entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfColour = Integer.parseInt(scanner.nextLine());
                    lookingForLaptop.setColour((String)mapOfAllCaracters.get("Цвет").get(numOfColour));
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "3":
                    System.out.println("Выберите тип процессора из списка: \n");
                    for (var item : mapOfAllCaracters.get("Процессор").entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfCPU = Integer.parseInt(scanner.nextLine());
                    lookingForLaptop.setCPUtype((String)mapOfAllCaracters.get("Процессор").get(numOfCPU));
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "4":
                    System.out.println("Выберите минимальный размер экрана из списка: \n");
                    for (var item : mapOfAllCaracters.get("ОЗУ").entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfdisplay = Integer.parseInt(scanner.nextLine());
                    lookingForLaptop.setDisplaySize((Integer)mapOfAllCaracters.get("ОЗУ").get(numOfdisplay));
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "5":
                    System.out.println("Выберите минимальный размер оперативной памяти из списка: \n");
                    for (var item : mapOfAllCaracters.get("ОЗУ").entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfRam = Integer.parseInt(scanner.nextLine());
                    lookingForLaptop.setAmountOfRAM((Integer)mapOfAllCaracters.get("ОЗУ").get(numOfRam));                    
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "6":
                    System.out.println("Выберите минимальный размер жесткого диска из списка: \n");
                    for (var item : mapOfAllCaracters.get("Память").entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfHdd = Integer.parseInt(scanner.nextLine());
                    lookingForLaptop.setAmountOfHDD((Integer)mapOfAllCaracters.get("Память").get(numOfHdd));            
                    System.out.println(lookingForLaptop);
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "7":
                    work = false;
                    break;
            
                default :
                    System.out.println("Команда не распознана. " + 
                                        "Выберите один из пунктов меню:\n");
                    menu();
                    menuNo = scanner.nextLine();
                    break;
            }        
        }
        scanner.close();
        //mapToset(findMap);
        System.out.println("Вы выбрали следующие критерии отбора: " + lookingForLaptop);
        
        filter(laptops, lookingForLaptop);
    }

    static void printSet(Set<Laptop> set) {
        for (Laptop laptop : set) {
            System.out.printf("%s \n", laptop);
        }
        System.out.println();
    }

    static Set<Object> mapToSet(Map<Integer, Object> map){
        Set<Object> setOfLaptops = new HashSet<>();
        for (var mapItem : map.keySet()) {
            setOfLaptops.add(map.get(mapItem));
        }
        return setOfLaptops;
    }

    private static void menu() {
        System.out.println("\n1. Производитель\n" +
                            "2. Цвет\n" + 
                            "3. Тип процессора\n" + 
                            "4. Диагональ экрана\n" + 
                            "5. Объем оперативной памяти\n" + 
                            "6. Объем жесткого диска\n" + 
                            "7. Выполнить Поиск");
    }

    private static void filter(Set<Laptop> laptops, Laptop lookingForLaptop) {
        Set<Laptop> filteredSet = new HashSet<>();
        for (var laptop : laptops) {
            if (laptop.getBrand().equals(lookingForLaptop.getBrand()) || laptop.getColour().equals(lookingForLaptop.getColour()) ||
                laptop.getCPUtype().equals(lookingForLaptop.getCPUtype()) || laptop.getDisplaySize() >= lookingForLaptop.getDisplaySize() ||
                laptop.getAmountOfRAM() >= lookingForLaptop.getAmountOfRAM() || laptop.getAmountOfHDD() >= lookingForLaptop.getAmountOfHDD()){
                filteredSet.add(laptop);
            }
        }
        
        if (filteredSet.isEmpty()) {
            System.out.println("К сожалению, мы ничего не нашли повашему запросу.");
        } else {
            System.out.println("\nВот что мы подобрали для вас: \n");
        }
        printSet(filteredSet);
    }          
    
}