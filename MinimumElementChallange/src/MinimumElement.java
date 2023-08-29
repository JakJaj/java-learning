import java.util.Scanner;

public class MinimumElement {

    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pass an integer:");
        return scanner.nextInt();
    }
    public static int[] readElements(int length){
        int[] array = new int[length];
        System.out.println("Created array that can store " + length + " integers");
        for(int i = 0; i < length; i++){
            System.out.println("Integer #" + i);
            array[i] = readInteger();
        }
        return array;
    }
    
}
