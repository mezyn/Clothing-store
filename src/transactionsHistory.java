import java.util.Scanner;

public class transactionsHistory {
    public transactionsHistory() {
    }

    static void transactionsHistoryOption() {
        Scanner transactionsHistoryMenu = new Scanner(System.in);
        System.out.println("Transactions History options menu:\n0. Return to Main Menu.\n1. Print total profit from all item purchases.\n2. Print total units sold from all item purchases.\n3. Print the total number of item transactions made.\n4. Print all transactions made.\n5. Print the total profit of a specific item.\n6. Print the number of units sold of a specific item.\n7. Print all transactions of a specific item.\n8. Print item with highest profit.\nType an option number:\n");
        byte counter = 0;

        do {
            int option = transactionsHistoryMenu.nextInt();
            switch(option) {
                case 0:
                    System.out.println("1");
                case 1:
                    System.out.println("2");
                case 2:
                    System.out.println("3");
                case 3:
                    System.out.println("4");
                case 4:
                    System.out.println("5");
                case 5:
                    System.out.println("6");
                case 6:
                    System.out.println("7");
                case 7:
                    System.out.println("8");
                case 8:
                    System.out.println("9");
            }

            System.out.println("please enter a valid option");
        } while(counter >=7);

        transactionsHistoryMenu.close();
    }
}
