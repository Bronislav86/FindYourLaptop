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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
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
        laptop4.amountOfHDD = 1000;

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

    }

    static HashMap<Object, Object> findBy(){
        HashMap<Object, Object> resLaptops = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пункт меню: " +
                            "1. Производитель" +
                            "2. Цвет" + 
                            "3. Диагональ экрана" + 
                            "4. Тип процессора" + 
                            "5. Объем оперативной памяти" + 
                            "6. Объем жесткого диска");
        int menuNum = scanner.nextLine();
        
        return resLaptops;
    } 

    private static void printSet(Set<Laptop> set) {
        for (Laptop laptop : set) {
            System.out.println(laptop);
        }
    }

}