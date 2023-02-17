package Java_HW_2;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {

    public static void print(int a, int b) throws IOException {             // метод записи результата в фаил
        try (FileWriter writer = new FileWriter("Java_HW_2\\output.txt", false)) {
            if (a == 0 && b == 0){
                writer.write("не определено");
                writer.close();
            }
            else {
                writer.write(String.format("%d в степени %d = %d", a , b, Exp.mult(a, b)));
                writer.close();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
