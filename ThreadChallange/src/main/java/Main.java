public class Main {
    public static void main(String[] args) {

        Thread oddNumber = new OddNumbersThread();

        Thread evenNumber = new Thread( () -> {

            for(int i = 1; i<= 10; i+=2){
                System.out.println("even numbers thread: " + i);
                try{
                    Thread.sleep(1500);
                }catch (InterruptedException e){
                    System.out.println("Even number thread interupted");

                }
            }
        });

        evenNumber.start();
        oddNumber.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



        oddNumber.interrupt();
    }
}
