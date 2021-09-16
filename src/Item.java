import java.util.Scanner;

public class Item {
    static void itemOption() {
        Scanner itemMenu = new Scanner(System.in);
        System.out.println("Item options menu: \n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "Type a option");

        int counter = 0;
        do {
            int option = itemMenu.nextInt();

            switch (option) {
                case 0 : System.out.println("1");// all println below are temporary.
                case 1 : System.out.println("2");
                case 2 : System.out.println("3");
                case 3 : System.out.println("4");
                case 4 : System.out.println("5");
                case 5 : System.out.println("6");
                case 6 : System.out.println("7");
                default : System.out.println("Please enter a valid option");
                 break;
                }
            } while (counter >= 5) ;
        itemMenu.close();
    }

}
