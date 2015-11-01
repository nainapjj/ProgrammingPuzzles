import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {

    // Sorts the list out-of-place, but stable!
    public static List<Integer> mergeSort(List<Integer> list) {
        return mergeSortRecursive(list);
    }

    private static List<Integer> mergeSortRecursive(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        // Divide and conquer sort.
        List<Integer> beginList = mergeSortRecursive(list.subList(0, list.size() / 2));
        List<Integer> endList = list.subList(list.size() / 2, list.size());

        // Return the merged sorted list!
        return merge(beginList, endList);
    }

    private static List<Integer> merge(List<Integer> listOne, List<Integer> listTwo) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        int indexOne = 0, indexTwo = 0;

        while (indexOne < listOne.size() || indexTwo < listTwo.size()) {
            if (indexOne >= listOne.size()) {
                // List one is exhausted. Add list two items to newList
                newList.add(listTwo.get(indexTwo));
                indexTwo++;
            } else if (indexTwo >= listTwo.size()) {
                // List two is exhausted.
                newList.add(listOne.get(indexOne));
                indexOne++;
            } else {
                if (listOne.get(indexOne) < listTwo.get(indexTwo)) {
                    newList.add(listOne.get(indexOne));
                    indexOne++;
                } else {
                    newList.add(listTwo.get(indexTwo));
                    indexTwo++;
                }
            }
        }

        return newList;
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
        list = new ArrayList<Integer>(mergeSort(list));
        outputList(list);

    }

}

