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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //private static Laptop findParameters = new Laptop("null", "null", 0, "null", 0, 0);

    public static void main(String[] args) {

        //Laptop laptop6 = new Laptop("Mac", "Grey", 16, "Intel", 16, 1000);

        Laptop laptop1 = new Laptop();
        laptop1.brand = "Huawei";
        laptop1.colour = "Grey";
        laptop1.displaySize = 15;
        laptop1.CPUtype = "IntelCorei5";
        laptop1.amountOfRAM = 16;
        laptop1.amountOfHDD = 1000;

        Laptop laptop2 = new Laptop();
        laptop2.brand = "ASUS";
        laptop2.colour = "White";
        laptop2.displaySize = 17;
        laptop2.CPUtype = "IntelCorei3";
        laptop2.amountOfRAM = 8;
        laptop2.amountOfHDD = 512;

        Laptop laptop3 = new Laptop();
        laptop3.brand = "Hewlett-Packard";
        laptop3.colour = "Grey";
        laptop3.displaySize = 16;
        laptop3.CPUtype = "IntelCorei7";
        laptop3.amountOfRAM = 4;
        laptop3.amountOfHDD = 256;

        Laptop laptop4 = new Laptop();
        laptop4.brand = "MSI";
        laptop4.colour = "Black";
        laptop4.displaySize = 17;
        laptop4.CPUtype = "AMD";
        laptop4.amountOfRAM = 16;
        laptop4.amountOfHDD = 128;

        Laptop laptop5 = new Laptop();
        laptop5.brand = "VAIO";
        laptop5.colour = "Red";
        laptop5.displaySize = 14;
        laptop5.CPUtype = "IntelCeleron";
        laptop5.amountOfRAM = 8;
        laptop5.amountOfHDD = 512;

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);

        Map<Integer, String> mapBrands = new HashMap<>();
        mapBrands.put(1, laptop1.getBrand());
        mapBrands.put(2, laptop2.getBrand());
        mapBrands.put(3, laptop3.getBrand());
        mapBrands.put(4, laptop4.getBrand());
        mapBrands.put(6, laptop5.getBrand());

        Map<Integer, String> mapColours = new HashMap<>();
        mapColours.put(1, "Grey");
        mapColours.put(2, "Black");
        mapColours.put(3, "Red");
        mapColours.put(4, "White");

        // List<Object> CPUtype = new LinkedList<>();
        // CPUtype.add(laptop1.getCPUtype());
        // CPUtype.add(laptop2.getCPUtype());
        // CPUtype.add(laptop3.getCPUtype());
        // CPUtype.add(laptop4.getCPUtype());
        // CPUtype.add(laptop5.getCPUtype());

        // List<Object> displays = new LinkedList<>();
        // displays.add(14);
        // displays.add(15);
        // displays.add(16);
        // displays.add(17);

        // List<Object> ram = new LinkedList<>();
        // ram.add(128);
        // ram.add(256);
        // ram.add(512);
        // ram.add(1000);

        // List<Object> hdd = new LinkedList<>();
        // hdd.add(128);
        // hdd.add(256);
        // hdd.add(512);
        // hdd.add(1000);

        // Map<String, LinkedList<Object>> parameters = new HashMap<>();
        // parameters.putIfAbsent("Производитель", (LinkedList<Object>) brands);
        // parameters.putIfAbsent("Цвет", (LinkedList<Object>) colours);
        // parameters.putIfAbsent("Процессор", (LinkedList<Object>) CPUtype);
        // parameters.putIfAbsent("Экран", (LinkedList<Object>) displays);
        // parameters.putIfAbsent("ОЗУ", (LinkedList<Object>) ram);
        // parameters.putIfAbsent("Память", (LinkedList<Object>) hdd);

        // parameters.get("Производитель");


        //System.out.println(parameters);
        findBy(laptops, mapBrands, mapColours);
    }

    static void findBy(Set<Laptop> laptops, Map<Integer, String> mapBrands, Map<Integer, String> mapColours){
        System.out.println("\nПредставляем вашему вниманию имеющийся ассортимент ноутбуков: \n");
        printSet(laptops);
        Map<String, Object> findMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Чтобы подобрать устройство для себя введите цифру, соответствующую критерию поиска: \n");
        menu();
        boolean work = true;
        while (work) {
            String menuNo  = scanner.nextLine();
                       
            switch (menuNo) {
                case "1":
                    System.out.println("Выберите производителя из списка: ");
                    for (var item : mapBrands.entrySet()) {
                        System.out.printf("%d. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfBrend = Integer.parseInt(scanner.nextLine());                    
                    findMap.put("1", mapBrands.get(numOfBrend));
                    for (var findItem : findMap.entrySet()) {
                        System.out.printf("%s ", findItem.getValue());
                    }
                    System.out.println("\n\nВведите следующую команду: ");
                    break;
                case "2":
                    System.out.println("Выберите цвет из списка: \n");
                    for (var item : mapColours.entrySet()) {
                        System.out.printf("%s. %s\n", item.getKey(), item.getValue());
                    }
                    int numOfColour = Integer.parseInt(scanner.nextLine());
                    findMap.put("2", mapColours.get(numOfColour));
                    for (var findItem : findMap.entrySet()) {
                        System.out.printf("%s ", findItem.getValue());
                    }
                    System.out.println("\n\nВведите следующую команду:");
                    menu();
                    break;
                case "3":
                    
                    break;
                case "4":
                    
                    break;
                case "5":
                    
                    break;
                case "6":
                    
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
        filter();
    } 

    private static void menu() {
        System.out.println("\n1. Производитель\n" +
                            "2. Цвет\n" + 
                            "3. Диагональ экрана\n" + 
                            "4. Тип процессора\n" + 
                            "5. Объем оперативной памяти\n" + 
                            "6. Объем жесткого диска\n" + 
                            "7. Выполнить Поиск");
    }

    private static void filter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    private static void printSet(Set<Laptop> set) {
        for (Laptop laptop : set) {
            System.out.printf("%s \n", laptop);
        }
        System.out.println();
    }

    

}