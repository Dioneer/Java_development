package Pegas.Seminar3.Hw3.Calculate;

public final class Calculate{
    public static void main(String[] args) {
        /**
         * sum
         */
        System.out.println(sum(8.0,8, (Double n, Integer k) -> n.intValue() +k));
        System.out.println(sum(8.2f,8.0f, Float::sum));
        System.out.println(sum(8,8.0f, (Integer n, Float k) -> n+k));
        System.out.println(sum(8,8.0, (Integer n, Double k) -> n+k));
        /**
         * Multi
         */
        System.out.println(multi(8.0,8, (Double n, Integer k) -> n.intValue()*k));
        System.out.println(multi(8.2f,8.0f, (Float n, Float k)-> n*k));
        System.out.println(multi(8,8.0f, (Integer n, Float k) -> n*k));
        System.out.println(multi(8,8.0, (Integer n, Double k) -> n*k));
        /**
         * Divide
         */
        System.out.println(divide(8.0,8, (Double n, Integer k) -> n.intValue()/k));
        System.out.println(divide(8.2f,8.0f, (Float n, Float k)-> n/k));
        System.out.println(divide(8,8.0f, (Integer n, Float k) -> n/k));
        System.out.println(divide(8,8.0, (Integer n, Double k) -> n/k));
        /**
         * Subtract
         */
        System.out.println(subtract(8.0,8, (Double n, Integer k) -> n.intValue()-k));
        System.out.println(subtract(8.2f,8.0f, (Float n, Float k)-> n-k));
        System.out.println(subtract(8,8.0f, (Integer n, Float k) -> n-k));
        System.out.println(subtract(8,8.0, (Integer n, Double k) -> n-k));
    }

    public static <T extends Number,N extends Number> N sum(T n1, N n2, Action<T,N> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number,N extends Number> N divide(T n1, N n2, Action<T,N> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number,N extends Number> N multi(T n1, N n2, Action<T,N> action){
        return action.apply(n1, n2);
    }
    public static <T extends Number,N extends Number> N subtract(T n1, N n2, Action<T,N> action){
        return action.apply(n1, n2);
    }
}
