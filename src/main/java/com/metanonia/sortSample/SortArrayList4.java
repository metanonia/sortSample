package com.metanonia.sortSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SortArrayList4 {
    public static void main(String[] args) {
// ArrayList 준비
        ArrayList<Fruit2> list = new ArrayList<>();
        list.add(new Fruit2("Apple", 2000));
        list.add(new Fruit2("Orange", 3000));
        list.add(new Fruit2("Banana", 1000));
        System.out.println("원본 : " + list); // [[ Apple: 2000 ], [ Orange: 3000 ], [ Banana: 1000 ]]
// price순 오름차순으로 정렬
        Collections.sort(list, new FruitPriceComparator());
        System.out.println("price 순 오름차순 : " + list); // [[ Banana: 1000 ], [ Apple: 2000 ], [ Orange: 3000 ]]
// price순 내림차순으로 정렬
        Collections.sort(list, new FruitPriceComparator().reversed());
        System.out.println("price 순 내림차순 : " + list); // [[ Orange: 3000 ], [ Apple: 2000 ], [ Banana: 1000 ]]
// name순 오름차순으로 정렬
        Collections.sort(list, new FruitNameComparator());
        System.out.println("price 순 오름차순 : " + list); // [[ Apple: 2000 ], [ Banana: 1000 ], [ Orange: 3000 ]]
// name순 내림차순으로 정렬
        Collections.sort(list, new FruitNameComparator().reversed());
        System.out.println("price 순 내림차순 : " + list); // [[ Orange: 3000 ], [ Banana: 1000 ], [ Apple: 2000 ]]
    }
}
class FruitPriceComparator implements Comparator<Fruit2> {
    @Override
    public int compare(Fruit2 f1, Fruit2 f2) {
        if (f1.price > f2.price) {
            return 1;
        } else if (f1.price < f2.price) {
            return -1;
        }
        return 0;
    }
}
class FruitNameComparator implements Comparator<Fruit2> {
    @Override
    public int compare(Fruit2 f1, Fruit2 f2) {
        return f1.name.compareTo(f2.name);
    }
}
class Fruit2 {
    String name;
    int price;
    public Fruit2(String name, int price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return "[ " + this.name + ": " + this.price + " ]";
    }
}