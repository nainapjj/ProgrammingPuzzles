import java.util.Scanner;

public class problem_1 {

    public static void main(String args[]) {
        // Create a scanner class in order to get access to standard input
        Scanner scanner = new Scanner(System.in);
        int maxValue = -1;

        while (maxValue == -1) {
            System.out.print("Enter the max number to scan until: ");

            if (scanner.hasNextInt()) {
                maxValue = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }

        int runningSum = 0;
        for (int i = 1; i < maxValue; i++) {
            if (i % 5 == 0 || i % 3 == 0) {
                runningSum += i;
            }
        }

        System.out.printf("The running sum of the multiples of 3 and " + 
            "5 less than %d: %d", maxValue, runningSum);
        System.out.println();
    }

}