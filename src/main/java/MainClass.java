import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()) {
            text.append(scanner.nextLine().toLowerCase());
            text.append('\n');
        }
        scanner.close();
        System.out.print(new WordSet(text.toString()));
    }
}
