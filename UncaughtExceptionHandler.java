public class UncaughtExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("This is the example of the custom uncaught exception handling.");
            System.out.print(exception.getClass().getSimpleName() + " was caught in ");
            System.out.println(thread.getName() + ".\n");
        });

        new Thread("Child Thread"){
            @Override
            public void run() {
                Thread.currentThread().setUncaughtExceptionHandler((thread, exception) -> {
                    System.out.println("One more example of the custom uncaught exception handling.");
                    System.out.print(exception.getClass().getSimpleName() + " was caught in ");
                    System.out.println(thread.getName() + ".\n");
                });

                System.out.println(args[0]);
            }
        }.start();

        Thread.sleep(500);

        System.out.println(1/0);
    }
}
