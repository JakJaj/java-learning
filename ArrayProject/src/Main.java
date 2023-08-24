import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] fistArray = randomArray(10);
        printArray(fistArray);

        int[] secondArray = Arrays.copyOf(fistArray, fistArray.length);

        printArray(secondArray);

        secondArray[5] = 11;
        secondArray[0] = 123;

        System.out.println("Zmiana");
        printArray(fistArray);
        printArray(secondArray);

    }

    public static int[] randomArray(int lenght){

        int[] array = new int[lenght];
        Random random = new Random();

        for(int i = 0; i < lenght; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }
}