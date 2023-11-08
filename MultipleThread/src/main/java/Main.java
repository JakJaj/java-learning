import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        StopWatch greenWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch purpleWatch = new StopWatch(TimeUnit.SECONDS);
        StopWatch redWatch = new StopWatch(TimeUnit.SECONDS);

        Thread green = new Thread(greenWatch::countDown,ThreadColor.ANSI_GREEN.name());
        Thread purple = new Thread( () -> purpleWatch.countDown(7), ThreadColor.ANSI_PURPLE.name());
        Thread red = new Thread(redWatch::countDown,ThreadColor.ANSI_RED.name());
        purple.start();
        red.start();
        green.start();

    }

}

class StopWatch{

    private TimeUnit timeUnit;
    private int i;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown(){
        countDown(5);
    }
    public void countDown(int unitCount){

        String threadName = Thread.currentThread().getName();

        ThreadColor threadColor = ThreadColor.ANSI_RESET;
        try{
            threadColor = ThreadColor.valueOf(threadName);
        }catch (IllegalArgumentException ignore){
            //bad collor inputed by user
        }
        String color = threadColor.color();
        for (i  = unitCount; i > 0; i--){
            try{
                timeUnit.sleep(1);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.format("%s%s Thread: i = %d%n", color, threadName, i);
        }
    }
}
