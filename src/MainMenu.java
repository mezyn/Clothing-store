import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner OptionScan = new Scanner(System.in);

        System.out.println(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n\n" +
                        "Type any Option Number:");

        int option = OptionScan.nextInt();

        while (option != 0 && option != 1 && option != 2 && option != 3) {

            System.out.println("Type an alternative between 0 and 3.\nType any option number: ");
            option = OptionScan.nextInt();
        }

            switch (option) {
                case 0: System.out.println("Closed");
                    break;// create method
                case 1: Item.itemOption();
                    break;
                case 2: Review.ReviewMenu();
                    break;
                case 3: System.out.println("Transaction History");
                    break;

            }

            OptionScan.close();

        }
    }
