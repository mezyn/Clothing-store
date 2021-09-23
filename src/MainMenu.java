import java.util.Scanner;
// THIS IS MAIN
public class MainMenu {

    public static void MainMenu(){
        Scanner OptionScan = new Scanner(System.in);

        System.out.println(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n\n" +
                        "Type any Option Number:");

        int option = OptionScan.nextInt();

        while (option < 0 || option > 3) {

            System.out.println("Invalid menu option. Please type another option");
            option = OptionScan.nextInt();
        }

        switch (option) {
            case 0:
                System.out.println("Closed");
                break;// create method, need help from TA with this / Carl
            case 1:
                Item.itemOption();
                break;
            case 2:
                Review.ReviewMenu();
                break;
            case 3:
                TransactionHistory.transactionHistoryMenu();
                break; // Added method, so when "3" is pressed we have the transactionMenu printed /Carl



        }

        OptionScan.close();


    }

    public static void main(String[] args) {

        MainMenu();


        }
    }
