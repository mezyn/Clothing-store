import java.util.Scanner;

public class UserInput {

    public static Scanner scanner = new Scanner(System.in);

    public static double readDouble(String message) {

        System.out.println(message);
        double doubleValue = scanner.nextDouble();
        scanner.nextLine();

        return doubleValue;
    }

    public static int readInt(String message) {
        System.out.println(message);
        int intValue = scanner.nextInt();
        scanner.nextLine();
        return intValue;
    }

    public static String readLine(String message) {

        System.out.println(message);
        return scanner.nextLine();

    }

}