import java.util.Scanner;
//do you see this
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
                case 0 : System.out.println("1");
                        break;
                // all println below are temporary.
                case 1 : System.out.println("2");
                    break;
                case 2 : System.out.println("3");
                    break;
                case 3 : System.out.println("4");
                    break;
                case 4 : System.out.println("5");
                    break;
                case 5 : System.out.println("6");
                    break;
                case 6 : System.out.println("7");
                    break;
                default : System.out.println("Please enter a valid option");
                    break;
                }
            } while (counter >= 5) ;
        itemMenu.close();
    }

}
