import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

    // Sorts the list in place.
    public static void mergeSort(List<Integer> list) {
        mergeSortRecursive(list]);
    }

    private static void mergeSortRecursive(List<Integer> list) {
        if (start >= end) {
            // Either the pivot from the previous sort was at the end of the 
            // list (inequality case) OR the list contains one element (equality case)
            return;
        }

        int begin = start;
        int pivot = list.get(end);
        int finish = end;

        while (begin < finish) {
            if (list.get(begin) > pivot) {
                // Move the number to the left of the pivot.  Because
                // the pivot is on the end, this involves moving three numbers.
                list.set(finish, list.get(begin));
                list.set(begin, list.get(finish - 1));
                list.set(finish - 1, pivot);

                finish--;
            } else {
                begin++;
            }
        }

        // begin and finish should be equal! That means the pivot is in the right 
        // place (pivot location == begin == finish)

        // Divide and conquer on the left list and right list
        quickSortRecursive(list, start, begin - 1);
        quickSortRecursive(list, begin + 1, end);
    }

    public static void outputList(List<Integer> list) {
        System.out.println("List Output:");
        for (int i : list) {
            System.out.printf("%d ", i);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int input = 0;

        while (input != -1) {
            System.out.print("Enter positive value: ");
            input = userInput.nextInt();

            if (input != -1) {
                list.add(input);
            }
        }

        outputList(list);
        mergeSort(list);
        outputList(list);

    }

}

