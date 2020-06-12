class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("The exception " + e.getClass().getSimpleName() + " is caught.");
    }
}

public class DefaultUncaughtExceptionTester {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler myHandler = new MyUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(myHandler);

        new Thread() {
            @Override
            public void run() {
                System.out.println(1 / 0);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println(args[0]);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Object o = new Object();
                DefaultUncaughtExceptionTester e = (DefaultUncaughtExceptionTester) o;
            }
        }.start();
    }
}
