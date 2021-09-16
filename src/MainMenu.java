import java.util.Scanner;

public class MainMenu {
    public static void main (String[] args){

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
                case 0 : System.out.println("Closed"); // create method
                case 1 : Item.itemOption();
                case 2 : Review.ReviewMenu();
                case 3 : System.out.println("Transaction History");
                default : System.out.println("Please enter a valid option");
            }
        } while (counter >= 5) ;
        OptionScan.close();
        }
    }