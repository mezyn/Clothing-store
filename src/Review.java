import java.util.Scanner;

public class Review {
    static void ReviewMenu() {
        Scanner ReviewMenu = new Scanner(System.in);
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
                "10. Print item(s) with worst mean review grade.\n" +
                "\n" +
                "Type an option number:\n");


        int counter = 0;
        do {
            int option = ReviewMenu.nextInt();

            switch (option) {
                case 0 : System.out.println("Option 1");
                case 1 : System.out.println("Option 2");
                case 2 : System.out.println("Option 3");
                case 3 : System.out.println("Option 4");
                case 4 : System.out.println("Option 5");
                case 5 : System.out.println("Option 6");
                case 6 : System.out.println("Option 7");
                case 7 : System.out.println("Option 8");
                case 8 : System.out.println("Option 9");
                case 9 : System.out.println("Option 10");
                default : System.out.println("Please enter a valid option");
            }
        } while (counter >= 5) ;
        ReviewMenu.close();
    }


}