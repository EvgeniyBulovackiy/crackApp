package ua.bulovackiy.process;

/**
 * @author Evgeniy Bulovackiy
 * @version 1.0
 */

public class ThreadProcess implements Runnable {

    private static int start;
    private static int end = 20;
    private final int step = 20;

    @Override
    public void run() {
        BruteRunnable bruteRunnable = new BruteRunnable();

        bruteRunnable.setStart(String.valueOf(start));
        bruteRunnable.setEnd(String.valueOf(end));
        Thread t = new Thread(bruteRunnable);
        t.start();
        start = end;
        end += step;
        try {
            t.join();
            System.out.println(t.getName() + "is over.");
            run();
            System.out.println("New thread is run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
