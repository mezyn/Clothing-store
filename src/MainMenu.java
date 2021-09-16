import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner OptionScan = new Scanner(System.in);
        System.out.println(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n" +
                        "Type any Option Number:");

        int counter = 0;
        do {
            int option = OptionScan.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Closed"); // create method
                    break;
                case 1:
                    Item.itemOption();
                    break;
                case 2:
                    Review.ReviewMenu();
                    break;
                case 3:
                    System.out.println("Transaction History");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while (counter >= 5);
        OptionScan.close();
    }
}