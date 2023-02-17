package Java_HW_2;
import java.io.*;
import java.util.stream.Collectors;

public class ReadInput {
    static String tempB;
    static String tempA;
    static int a;
    static int b;

    public static int inputReader(String variable) throws IOException {             // метод считывания вчодных данных
        BufferedReader br = new BufferedReader(new FileReader("Java_HW_2\\input.txt"));
        String str;

        while ((str = br.readLine()) != null){
            if (str.contains("a")){
                tempA = str.chars()
                        .filter(c -> !Character.isLetter(c))
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
                        .trim();
            }
            else if (str.contains("b")){
                tempB = str.chars()
                        .filter(c -> !Character.isLetter(c))
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
                        .trim();
            }
            else {
                System.out.println("Неверный формат!\n запишите в виде:\nb [число]\na [число]");
                break;
            }
        }
        br.close();

        if (variable == "a"){
            return a = Integer.parseInt(tempA);
        }
        else {
            return b = Integer.parseInt(tempB);
        }
    }
}
