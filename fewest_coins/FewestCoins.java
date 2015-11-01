import java.util.Scanner;

public class FewestCoins {

    static final int currency[] = {1, 15, 20};

    public static int dpFindChange(int exactChange) {
        // Dyanmic Programming: Solve subproblems that lead up to the problem
        // we're aiming to solve.
        int subproblems[] = new int[exactChange + 1];

        subproblems[0] = 0;

        for (int i = 1; i <= exactChange; i++) {
            subproblems[i] = Integer.MAX_VALUE;
            for (int coin : currency) {
                if (i >= coin) {
                    subproblems[i] = Math.min(subproblems[i], subproblems[i - coin] + 1);
                }
            }
        }

        // When the loop is done, we've obtained our answer.
        return subproblems[exactChange];
    }

    public static void main(String args[]) {
        // Create a scanner class in order to get access to standard input
        Scanner scanner = new Scanner(System.in);
        int exactChange = -1;

        while (exactChange == -1) {
            System.out.print("Enter the max number to scan until: ");

            if (scanner.hasNextInt()) {
                exactChange = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        int coins = dpFindChange(exactChange);

        System.out.printf("The fewest coins to give for this change amount is: " + 
            "%d", coins);
        System.out.println();
    }
}