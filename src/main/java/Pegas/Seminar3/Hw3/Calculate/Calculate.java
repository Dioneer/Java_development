package Pegas.Seminar3.Hw3.Calculate;

public final class Calculate{

    public static void main(String[] args) {
        /**
         * sum
         */
        System.out.println(sum(8.0,8, (Number n, Number  k) -> n.doubleValue()+k.doubleValue()));
        System.out.println(sum(8.2f,8.0f, (Number n, Number  k) -> n.doubleValue()+k.doubleValue()));
        System.out.println(sum(8,8.0f, (Number n, Number  k) -> n.doubleValue()+k.doubleValue()));
        System.out.println(sum(8,8.0, (Number n, Number  k) -> n.doubleValue()+k.doubleValue()));
        /**
         * Multi
         */
        System.out.println(multi(8.0,8, (Number n, Number  k) -> n.doubleValue()*k.doubleValue()));
        System.out.println(multi(8.2f,8.0f, (Number n, Number  k)-> n.doubleValue()*k.doubleValue()));
        System.out.println(multi(8,8.0f, (Number n, Number  k) -> n.doubleValue()*k.doubleValue()));
        System.out.println(multi(8,8.0, (Number n, Number  k) -> n.doubleValue()*k.doubleValue()));
        /**
         * Divide
         */
        System.out.println(divide(8.0,8, (Number n, Number  k) -> n.doubleValue()/k.doubleValue()));
        System.out.println(divide(8.2f,8.0f, (Number n, Number  k)-> n.doubleValue()/k.doubleValue()));
        System.out.println(divide(8,8.0f, (Number n, Number  k) -> n.doubleValue()/k.doubleValue()));
        System.out.println(divide(8,8.0, (Number n, Number  k) -> n.doubleValue()/k.doubleValue()));
        /**
         * Subtract
         */
        System.out.println(subtract(8.0,8, (Number n, Number  k) -> n.doubleValue()-k.doubleValue()));
        System.out.println(subtract(8.2f,8.0f, (Number n, Number  k)-> n.doubleValue()-k.doubleValue()));
        System.out.println(subtract(8,8.0f, (Number n, Number  k) -> n.doubleValue()-k.doubleValue()));
        System.out.println(subtract(8,8.0, (Number n, Number  k) -> n.doubleValue()-k.doubleValue()));
    }

    public static <T extends Number> double sum(T n1, T n2, Action<T> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number> double divide(T n1, T n2, Action<T> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number> double multi(T n1, T n2, Action<T> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number> double subtract(T n1, T n2, Action<T> action){
        return action.apply(n1, n2);
    }
}
