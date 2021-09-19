import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Main Menu: Please choose among the options below. \n\n" +
                        "0. Close system.\n" +
                        "1. Open Item options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History options.\n\n" +
                        "Type an option number: ");

        int option = scanner.nextInt();

        while (option != 0 && option != 1 && option != 2 && option != 3) {

            System.out.println("Type an option number between 0 and 3: ");
            option = scanner.nextInt();
        }

            switch (option) {
                case 0:
                    System.out.println("Closed");
                    break;// create method
                case 1:
                    Item.itemOption();
                    break;
                case 2:
                    Review.ReviewMenu();
                    break;
                case 3:
                    TransactionHistory.transactionHistoryMenu();
                    break;
            }

            scanner.close();

        }
    }
