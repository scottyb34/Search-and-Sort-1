import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SearchSort {
    public static void bubbleSort(String[] arr) {
        boolean made_a_swap = true;
        while(made_a_swap) {
            made_a_swap = false;
            for(int i = 0; i < arr.length - 1; ++i) {
                if(arr[i].compareTo(arr[i + 1]) > 0) {
                    String t = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = t;
                    made_a_swap = true;
                }
            }
        }
    }

    // takes a sorted array and returns the index of the desired string or -1 if not found
    public static int binarySearch(String[] arr, String lookfor) {
        return -1;
    }

    public static String[] mergeSort(String[] arr) {
        return null;
    }

    private static String[] merge(String[] a, String[] b) {
        return null;
    }

    public static void quickSort(String[] arr) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        List<String> names = new ArrayList<String>();
        while(sc.hasNextLine())
            names.add(sc.nextLine());
        String[] arr = names.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(arr));


        // call stuff
    }
}
