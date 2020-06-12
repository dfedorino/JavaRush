class FirstThreadGroup extends ThreadGroup implements Runnable{

    public FirstThreadGroup() {
        super("First Thread Group");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("The exception " + e.getClass().getSimpleName() +
                " is caught in " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try{
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is running.");
                Thread.sleep(1000);
            }

        } catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " is interrupted: " + e.toString());
            throw new IllegalArgumentException();
        }
    }
}

public class ThreadGroupExceptionHandlerTester {
    public static void main(String[] args) throws InterruptedException {
        new ThreadGroupExceptionHandlerTester().init();
    }

    public void init() throws InterruptedException {
        FirstThreadGroup ftg = new FirstThreadGroup();
        ThreadGroup tg = ftg;
        Thread t1 = new Thread(ftg, ftg, "Thread #1");

        t1.start();

        new Thread(tg, "Thread #2"){
            @Override
            public void run() {
                try {
                    System.out.println("Thread's #2 own logic here. Thread #2 is running");
                    Thread.sleep(2500);
                    throw new RuntimeException();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread.sleep(5000);

        t1.interrupt();
    }
}
