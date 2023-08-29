import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] array){
        int[] reversed = new int[array.length];
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length; i ++){
            reversed[reversed.length - i - 1] = array[i];
        }
        array = reversed;
        System.out.println(Arrays.toString(array));
    }
}
