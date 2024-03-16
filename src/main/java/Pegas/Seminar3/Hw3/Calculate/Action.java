package Pegas.Seminar3.Hw3.Calculate;

public interface Action<T extends Number,N extends Number> {
    N apply(T n1, N n2);
}
