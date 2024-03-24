package Pegas.Seminar3.Hw3.Calculate;

public interface Action<T extends Number> {
    double apply(T n1, T n2);
}
