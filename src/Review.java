import java.util.Scanner;

public class Review {
    static void ReviewMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n\n" +
                "Type an option number: ");

        int option = scanner.nextInt();

        while (option != 0 && option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7 && option != 8 && option != 9 && option != 10) {

            System.out.println("Invalid menu option. Please type another option");
            option = scanner.nextInt();
        }

            switch (option) {
                case 0 : Menu.MenuMain();
                    break;
                case 1 : System.out.println("Option 2");
                    break;
                case 2 : System.out.println("Option 3");
                    break;
                case 3 : System.out.println("Option 4");
                    break;
                case 4 : System.out.println("Option 5");
                    break;
                case 5 : System.out.println("Option 6");
                    break;
                case 6 : System.out.println("Option 7");
                    break;
                case 7 : System.out.println("Option 8");
                    break;
                case 8 : System.out.println("Option 9");
                    break;
                case 9 : System.out.println("Option 10");
                    break;
                default : System.out.println("Please enter a valid option");
                    break;
            }
        scanner.close();
    }

}