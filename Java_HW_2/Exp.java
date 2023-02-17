package Java_HW_2;

public class Exp {        // метод возведения в степень
    public static int mult(int a, int b) {
        int num = 1;
        for (int i = 0; i <= b; i++) {
            num = num * a;
        }
        return num;
    }
}
