import java.util.Scanner;

public class ItemScanner {

    public static Scanner scanner = new Scanner(System.in);

    public static double readDouble(String message) {

        System.out.println(message);
        double doubleValue = scanner.nextDouble();

        while (doubleValue < 0 || doubleValue == 0) {

            System.out.println("Invalid data for item.");
            System.out.println(message);
            doubleValue = scanner.nextDouble();
        }
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
        String input = scanner.nextLine();

        while (input.trim().equals("")) {

            System.out.println("Invalid data for item.");
            System.out.println(message);
            input = scanner.nextLine();
        }
        return input;
    }

}