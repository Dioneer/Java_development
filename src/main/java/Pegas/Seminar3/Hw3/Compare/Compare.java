package Pegas.Seminar3.Hw3.Compare;

import java.util.Arrays;

public final class Compare {
    public static void main(String[] args) {
        Object[] arr1 = new Object[5];
        Object[] arr2 = new Object[5];
        for (int i = 0; i < 3; i++) {
            arr1[i] = "hi";
            arr2[i] = "ih";
        }
        for (int i = 3; i < 5; i++) {
            arr1[i] = i;
            arr2[i] = i;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(compareArrays(arr1, arr2));
    }
    public static <T, K> boolean compareArrays(T[] arr1, K[] arr2){
        if(arr1.length==arr2.length){
            for (int i = 0; i < arr1.length; i++) {
                if(!arr1[i].equals(arr2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
