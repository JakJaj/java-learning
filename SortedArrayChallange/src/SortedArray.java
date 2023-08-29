import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int size){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[size];
        for(int i = 0; i< size;i++){
            System.out.println("Can I get #" + i + " number?");
            String input = scanner.nextLine();
            System.out.println("You added " + input + " to your list");
            arr[i] = Integer.parseInt(input);
        }
        return arr;
    }


    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }

    public static int[] sortIntegers(int[] arr){
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        for(int i = 0; i< result.length;i++){
            result[i] = arr[arr.length - i];
        }
        return result;
    }
}
