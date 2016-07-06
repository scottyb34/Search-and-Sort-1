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
        //call binarySearchHelper
        return binarySearchHelper(arr, 0, arr.length, lookfor);
    }

    private static int binarySearchHelper(String[] arr, int lo, int hi, String lookfor) {
        //this should be done recursively.  Assume that the passed in array is sorted.  Look at the 
        //midpoint of the array and see if the string lookfor comes before or after the midpoint.
        //Then recursively call binarySearchHelper with the part of the array that you think holds "lookfor"
        //What are your base cases?  Handle the case where the string is not found.
        if(lo >= hi)
            return -1;
        int mid = (hi + lo) / 2;
        int c = arr[mid].compareTo(lookfor);
        if(c == 0)
            return mid;
        if(c < 0)
            return binarySearchHelper(arr, mid + 1, hi, lookfor);
        else
            return binarySearchHelper(arr, lo, mid, lookfor);
    }

    public static String[] mergeSort(String[] arr) {
        if(arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        String[] first = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        String[] second = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(first, second);
    }

    private static String[] merge(String[] a, String[] b) {
        int anext = 0, bnext = 0, rnext = 0;
        String[] ret = new String[a.length + b.length];

        while(anext < a.length || bnext < b.length) {
            String as = anext < a.length ? a[anext] : null;
            String bs = bnext < b.length ? b[bnext] : null;
            if(as == null) {
                ret[rnext] = bs;
                bnext++;
            }
            else if(bs == null) {
                ret[rnext] = as;
                anext++;
            }
            else if(as.compareTo(bs) < 0) {
                ret[rnext] = as;
                anext++;
            }
            else {
                ret[rnext] = bs;
                bnext++;
            }
            rnext++;
        }
        return ret;
    }

    public static void quickSort(String[] arr) {
        // be brave, use google
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


        System.out.println(binarySearch(arr, "Chewbacca"));
        System.out.println(binarySearch(arr, "Chewbaccawww"));


        String[] arr2 = names.toArray(new String[0]);
        arr2 = mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}
