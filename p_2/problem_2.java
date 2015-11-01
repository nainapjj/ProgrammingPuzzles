import java.util.Scanner;

public class problem_2 {

    public static void main(String[] args) {
        int i = 1, j = 2;
        int runningSum = 2;

        Scanner input = new Scanner(System.in);
        int maxFib = -1;

        while (maxFib == -1) {
            System.out.print("Enter the max fib int: ");
            if (input.hasNextInt()) {
                maxFib = input.nextInt();
            } else {
                // Clear the Scanner input, one line at a time.
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }
        }

        while (j <= maxFib) {
            int new_i = j;
            int new_j = i + j;

            if (new_j <= maxFib) {
                i = new_i;
                j = new_j;

                if (j % 2 == 0) {
                    // The next term is even.
                    runningSum += j; 
                }
            } else {
                break;
            }
            
        }

        System.out.printf("Last fib value was %d\n", j);
        System.out.printf("Running sum of the even fib values was: %d\n", 
            runningSum);
    }

}