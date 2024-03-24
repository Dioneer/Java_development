package Pegas.Seminar4.seminar;

import java.sql.Connection;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = createListName();
        sortByAlphabet(names);
        sortByLength(names);
        System.out.println(names);
        reverse(names);
        System.out.println(names);
    }
    private static void sortByAlphabet(List<String> arr){
        arr.sort(String::compareTo);
    }
    private static void sortByLength(List<String> arr){
        arr.sort(Comparator.comparingInt(String::length));
    }
    private static void reverse(List<String> arr){
        for (int i = 0; i <  arr.size()/2; i++) {
            String temp = arr.get(i);
            arr.set(i, arr.get(arr.size()-1-i));
            arr.set(arr.size()-1-i, temp);
        }
    }
    private static List<String> createListName(){
        List<String> list = new ArrayList<>();
        list.add("Kira");
        list.add("Agneshka");
        list.add("Lira");
        list.add("Mira");
        list.add("Rita");
        return list;
    }
}
