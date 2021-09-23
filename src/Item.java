
public class Item {
    static void itemOption() {

        int option = UserInput.readInt("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n\n" +
                "Type an option number: ");

        while (option < 0 || option > 6) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

            switch (option) {
                case 0 : MainMenu.MainMenuPage();
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
                }

        UserInput.scanner.close();
    }

}
