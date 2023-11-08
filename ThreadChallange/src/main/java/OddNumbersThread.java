public class OddNumbersThread extends Thread{

    @Override
    public void run() {
        int count = 0;
        for(int i = 0; i <= 10; i+=2){
            System.out.println("Odd numbers thread: " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Odd number thread interupted");
                break;
            }
        }
    }
}
