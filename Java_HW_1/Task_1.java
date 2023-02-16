package Java_HW_1;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число n: ");
        int n = iScanner.nextInt();
        System.out.printf("n-ое треугольное число равно %s",triangle_num(n));  
        iScanner.close();
    }

}
